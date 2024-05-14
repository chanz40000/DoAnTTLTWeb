package controller.user;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import model.ErrorBean;
import database.UserDAO;
import model.User;
import util.CountryIdentifier;
import util.IPv4Converter;
import util.PasswordEncryption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@WebServlet(name = "LoginForm", value = "/LoginForm")
public class LoginForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = PasswordEncryption.toSHA1(password);
        boolean check_error = false;
        HttpSession session = request.getSession();

        session.setAttribute("username", username);

        //kiem tra password
        if (password == null || password.trim().length() == 0) {
            check_error = true;
            request.setAttribute("e_password", "chua nhap mat khau");
        }

        UserDAO test = new UserDAO();
        User user = test.selectByUsernamePassword(username, password);
        System.out.println("nguoi dung: " + username);

        String url = "";


        if (user != null) {


            if (user.getRole() == 1) {
                session.setAttribute("admin", user);
                url = "/WEB-INF/book/index.jsp";
                response.sendRedirect(request.getContextPath() + url);

            } else {

                if (user != null) {
                    session.setMaxInactiveInterval(30 * 60);
                    session.setAttribute("customer", user);
                    url = "/WEB-INF/book/index.jsp";


                }
            }


        } else {
            request.setAttribute("Error", "ten dang nhap hoac mat khau chua chinh xac!");
            ErrorBean eb = new ErrorBean();
            eb.setError((String) request.getAttribute("Error"));
            request.setAttribute("errorBean", eb);

            url = request.getContextPath() + "/WEB-INF/book/logintwo.jsp";
            String encodedError = URLEncoder.encode(eb.getError(), "UTF-8");
            request.setAttribute("encodedError", encodedError);
            return;
        }
        if (url != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }*/
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

                if (user.getRole() == 1 || user.getRole() == 4) {
                    session.setAttribute("admin", user);
                    // Use sendRedirect for successful admin login
//                    String url = "/WEB-INF/admin/jsp/index.jsp";
                    String url = "/WEB-INF/admin/jsp/index.jsp";
                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                }else if(user.getRole() == 3 || user.getRole() == 5){
                    request.setAttribute("Error", "Tài khoản bạn đã bị khóa!");
                    eb.setError((String) request.getAttribute("Error"));
                    request.setAttribute("errorBean", eb);
                    String url = request.getContextPath() + "/WEB-INF/book/logintwo.jsp";
                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                }else {
                    //xác định thời gian, bằng giây, giữa các yêu cầu từ Client trước khi Servlet container sẽ vô hiệu hóa session này
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
//        } else {
//            // User hasn't attempted login, indicate non-logged-in state
//            request.setAttribute("notLoggedIn", true);
//            // Forward to index.jsp to display information for non-logged-in users
//            String url = "/WEB-INF/book/index.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//        }
//C:/Users/ADMIN/eclipse-workspace/BookWeb-master/src/main/java/util/GeoLite2-Country
        try {
            CountryIdentifier countryIdentifier = new CountryIdentifier();

            // Đây là request được đại diện bằng HttpServletRequest, bạn cần đảm bảo có request thực tế
            // Thay null bằng request thực tế
            String countryId = countryIdentifier.getCountryId(request);
            System.out.println("Quốc gia của bạn là: " + countryId);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    }

