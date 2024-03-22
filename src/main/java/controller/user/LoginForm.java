package controller.user;

import model.ErrorBean;
import database.UserDAO;
import model.User;
import util.PasswordEncryption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginForm", value = "/LoginForm")
public class LoginForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("usernamelo");
        String password = request.getParameter("passwordlo");
        ErrorBean eb = new ErrorBean();
        String baoLoi1 = "";
        // Encrypt password (assuming proper encryption implemented elsewhere)
        password = PasswordEncryption.toSHA1(password);

        HttpSession session = request.getSession();

        // Check for login attempt
        if (username != null && password != null) {
            UserDAO userDAO = new UserDAO(); // Assuming UserDAO is instantiated correctly
            User user = userDAO.selectByUsernamePassword(username, password);

            if (user != null) {
                session.setAttribute("username", username);
                System.out.println(username);

                if (user.getRole() == 1) {
                    session.setAttribute("admin", user);
                    session.setAttribute("userC", user);
                    session.setMaxInactiveInterval(30 * 60);
                    // Use sendRedirect for successful admin login
                    response.sendRedirect(request.getContextPath() + "/WEB-INF/book/index.jsp");
                } else {
                    session.setMaxInactiveInterval(30 * 60);
                    session.setAttribute("userC", user);
                    // Use forward for successful customer login
                    String url = "/WEB-INF/book/index.jsp";
                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                }
            } else {
                // Handle incorrect login credentials
                request.setAttribute("Error", "Tên đăng nhập hoặc mật khẩu chưa chính xác!");
                eb.setError((String) request.getAttribute("Error"));
                request.setAttribute("errorBean", eb);
                String url = request.getContextPath() + "/WEB-INF/book/logintwo.jsp";
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        }

    }
}
