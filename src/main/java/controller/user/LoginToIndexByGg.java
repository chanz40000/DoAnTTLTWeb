package controller.user;
import util.Constants;


import database.UserDAO;
import model.Role;
import model.User;
import model.UserGoogleDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
import static com.mysql.cj.conf.PropertyKey.logger;

import static com.mysql.cj.conf.PropertyKey.logger;
@WebServlet(name = "LoginToIndexByGg", value = "/LoginToIndexByGg")
public class LoginToIndexByGg extends HttpServlet {
    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        return new Gson().fromJson(response, UserGoogleDto.class);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("code");
        String accessTokens=getToken(code);
        UserGoogleDto userGoogleDto = getUserInfo(accessTokens);
        String userE = userGoogleDto.getEmail();
        UserDAO userD = new UserDAO();
        User user = userD.selectByEmail2(userE);
        System.out.println(userE);
        HttpSession session = request.getSession();

        // **Thêm code để xác định nguyên nhân email null:**
        if (user == null) {
            // Log the error message
            System.err.println("User not found: " + userE);
            // Redirect to the login page
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // **Ghi log chi tiết:**
        // Log the successful login
        System.out.println("User logged in: " + userE);

        if (user.getRole() == 1) {
            session.setAttribute("admin", user);
            // Use sendRedirect for successful admin login
            String url = "/WEB-INF/admin/jsp/index.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }else {
            session.setMaxInactiveInterval(30 * 60);
            session.setAttribute("userC", user);
            // Use forward for successful customer login
            String url = "/WEB-INF/book/index.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}