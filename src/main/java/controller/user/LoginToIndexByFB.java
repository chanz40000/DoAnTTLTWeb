package controller.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.UserDAO;
import model.AccountFB;
import model.User;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import util.ConstantsFB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "LoginToIndexByFB", value = "/LoginToIndexByFB")
public class LoginToIndexByFB extends HttpServlet {
    public static String getToken(String code) throws ClientProtocolException, IOException {
        String response = Request.Post(ConstantsFB.FACEBOOK_LINK_GET_TOKEN)
                .bodyForm(
                        Form.form()
                                .add("client_id", ConstantsFB.FACEBOOK_CLIENT_ID)
                                .add("client_secret", ConstantsFB.FACEBOOK_CLIENT_SECRET)
                                .add("redirect_uri", ConstantsFB.FACEBOOK_REDIRECT_URI)
                                .add("code", code)
                                .build()
                )
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static AccountFB getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = ConstantsFB.FACEBOOK_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        AccountFB fbAccount = new Gson().fromJson(response, AccountFB.class);
        return fbAccount;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            System.err.println("Authorization code is missing.");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        System.out.println("Authorization code: " + code);
        String accessToken = null;
        try {
            accessToken = getToken(code);
            System.out.println("Access token: " + accessToken);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        AccountFB userFBDto = null;
        try {
            userFBDto = getUserInfo(accessToken);
            System.out.println("User info: " + userFBDto);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String userE = userFBDto.getEmail();
        UserDAO userD = new UserDAO();
        User user = userD.selectByEmail2(userE);
        System.out.println("User email: " + userE);
        HttpSession session = request.getSession();
        if (user == null) {
            System.err.println("User not found: " + userE);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        System.out.println("User logged in: " + userE);
        if (user.getRole() == 1) {
            session.setAttribute("admin", user);
            String url = "/WEB-INF/admin/jsp/index.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } else {
            session.setMaxInactiveInterval(30 * 60);
            session.setAttribute("userC", user);
            String url = "/WEB-INF/book/index.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}