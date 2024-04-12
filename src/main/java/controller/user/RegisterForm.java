package controller.user;

import model.ErrorBean;
import database.UserDAO;
import model.User;
import util.Email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "RegisterForm", value = "/RegisterForm")
public class RegisterForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  try {
            String username = request.getParameter("usernamere");
            String name = request.getParameter("namere");
            String email = request.getParameter("emailre");
            String password = request.getParameter("passwordre");
            String enterThePassword = request.getParameter("enterThePasswordre");
            UserDAO cd = new UserDAO();
            ErrorBean eb = new ErrorBean();
            String baoLoi1 = "";
            String baoLoi2 = "";
            String baoloi3 = "";
            System.out.println(username);
            String url = "";
        *//*request.setAttribute("username", username);
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("password", password);
        request.setAttribute("enterThePassword", enterThePassword);*//*
            if (cd.selectByUsername(username)) {
                eb.setError("ten dang nhap da ton tai, vui long chon ten dang nhap khac");
                *//* request.setAttribute("name", "");*//*
                request.setAttribute("errorBean", eb);
                baoLoi1 += eb.getError();

                url = "/WEB-INF/book/register.jsp";
                String encodedError = URLEncoder.encode(eb.getError(), "UTF-8");
                request.setAttribute("encodedError", encodedError);

                return;

            } else if (cd.selectByEmail(email)) {
                eb.setError("ten email da ton tai, vui long chon email khac");
                *//*request.setAttribute("name", "");*//*
                request.setAttribute("errorBean", eb);
                baoLoi2 += eb.getError();
                url = "/WEB-INF/book/register.jsp";
                String encodedError = URLEncoder.encode(eb.getError(), "UTF-8");
                request.setAttribute("encodedError", encodedError);

                return;

            } else if (password != null && !password.equals(enterThePassword)) {
                eb.setError(" mat khau nhap lai khong dung");
                *//*request.setAttribute("password", "");*//*
                request.setAttribute("errorBean", eb);
                baoloi3 += eb.getError();
                url = "/WEB-INF/book/register.jsp";
                String encodedError = URLEncoder.encode(eb.getError(), "UTF-8");
                request.setAttribute("encodedError", encodedError);

                return;
            } else {
                User customer = new User((cd.creatId() + 1), username, password, 2, name, null, null, null, email, null);
                System.out.println("id cua customer: " + customer.getUserId());
                cd.insert(customer);
                Email.sendEmail(email, "Chuc mung ban da tro thanh khach hang than thiet cua cua hang chung toi!", "Thong bao dang ky tai khoan thanh cong");
                url = "/WEB-INF/book/logintwo.jsp";
            }
            if (url != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }*/


        /*else {
            url = "/WEB-INF/book/register.jsp";
            String encodedError = URLEncoder.encode(eb.getError(), "UTF-8");
            request.setAttribute("encodedError", encodedError);
            request.getRequestDispatcher(url).forward(request, response);
            return;

        }*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("usernamere");
            String name = request.getParameter("namere");
            String email = request.getParameter("emailre");
            String password = request.getParameter("passwordre");
            String enterThePassword = request.getParameter("enterThePasswordre");

            UserDAO cd = new UserDAO();
            ErrorBean eb1 = new ErrorBean();
            ErrorBean eb2 = new ErrorBean();
            ErrorBean eb3 = new ErrorBean();

            String url = "";
            String baoLoi1 = "";
            String baoLoi2 = "";
            String baoloi3 = "";

            // Kiểm tra định dạng email
            if (!isValidEmail(email)) {
                eb2.setError("Email của bạn không đúng định dạng abc@xyz.abc. Vui lòng nhập lại");
                request.setAttribute("errorBean2", eb2);
                baoLoi2 += eb2.getError();
                url = "/WEB-INF/book/register.jsp";
            } else if (cd.selectByUsername(username)) {
                eb1.setError("Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác");
                request.setAttribute("errorBean1", eb1);
                baoLoi1 += eb1.getError();

                url = "/WEB-INF/book/register.jsp";
            } else if (!isValidUserName(username)) {
                eb1.setError("Tên đăng nhập chỉ được chứa chữ và số và không chứa khoảng trắng");
                request.setAttribute("errorBean1", eb1);
                baoLoi1 += eb1.getError();

                url = "/WEB-INF/book/register.jsp";
            }
            else if (cd.selectByEmail(email)) {
                eb2.setError("Email đã tồn tại, vui lòng chọn email khác");
                request.setAttribute("errorBean2", eb2);
                baoLoi2 += eb2.getError();
                url = "/WEB-INF/book/register.jsp";

            }
            else if (!password.equals(enterThePassword)) {
                eb3.setError("Password nhập lại phải giống password");

                request.setAttribute("errorBean3", eb3);
                baoloi3 += eb3.getError();
                url = "/WEB-INF/book/register.jsp";
            }else if (!isValidPassword(password)) {
                eb3.setError("Password phải có từ 6-8 kí tự và chứa chữ hoặc số");

                request.setAttribute("errorBean3", eb3);
                baoloi3 += eb3.getError();
                url = "/WEB-INF/book/register.jsp";
            }

            else {
                User customer = new User((cd.creatId() + 1), username, password, 2, name, null, null, null, email, null);
                cd.insert(customer);
//                Email.sendEmail(email, "Chúc mừng bạn đã trở thành khách hàng thân thiết của cửa hàng chúng tôi!", "Thông báo đăng ký tài khoản thành công");
                url = "/WEB-INF/book/logintwo.jsp";
            }


            if (url != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private boolean isValidEmail(String email) {
        // Biểu thức chính quy kiểm tra định dạng email
        String regex = "^[a-zA-Z][a-zA-Z0-9\\-_]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
        /*Mật khẩu chỉ có thể chứa chữ hoặc số và có từ 6-8 kí tự*/
    }
    private boolean isValidPassword(String password) {
        // Biểu thức chính quy kiểm tra định dạng email
        String regex = "^[a-zA-Z0-9]{6,8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        return m.matches();
    }
    private boolean isValidUserName(String username) {
        // Biểu thức chính quy kiểm tra định dạng email
        String regex = "^[a-zA-Z0-9]*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(username);
        return m.matches();
    }


}


