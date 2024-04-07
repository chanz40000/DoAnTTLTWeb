package controller.user;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ErrorBean;
import database.UserDAO;
import model.User;
import util.PasswordEncryption;

/**
 * Servlet implementation class ChangeInformation
 */
@WebServlet(name = "changeInformation", value = "/changeInformation")
public class ChangeInformation extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ChangeInformation() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//
//
//        response.setContentType("text/html; charset=UTF-8");
//        HttpSession sesion  = request.getSession();
//
//
//
//        String url="";
//        String error = "";
//        ErrorBean eb = new ErrorBean();
//
//
//
//        if(user==null) {
//            eb.setError("Vui long dang nhap de sua thong tin ca nhan!");
//            url =  request.getContextPath() + "/pizza-gh-pages/pizza-gh-pages/login.jsp";
//            response.sendRedirect(url + "?error=" + URLEncoder.encode(eb.getError(), "UTF-8"));
//            return;
//        }else
//
//
////        if(userDAO.selectByUsername(username)&&!user.getUsername().equals(username)) {
////            eb.setError("ten dang nhap da ton tai, vui long chon ten dang nhap khac!");
////            request.setAttribute("name", "");
////            request.setAttribute("errorBean", eb);
////            error+=eb.getError();
////            url =  request.getContextPath() + "/pizza-gh-pages/pizza-gh-pages/changeInformation.jsp";
////            response.sendRedirect(url + "?error=" + URLEncoder.encode(eb.getError(), "UTF-8"));
////            return;
////
////        }else
//        if(username.length()>25) {
//            eb.setError("ten dang nhap khong duoc qua 25 ky tu!");
//            request.setAttribute("name", "");
//            request.setAttribute("errorBean", eb);
//            url = request.getContextPath() + "/WEB-INF/book/changeInformation.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//        return;}
////        }else
////        if(userDAO.selectByEmail(email)&&!user.getEmail().equals(email)) {
////            eb.setError("ten email da ton tai, vui long chon email khac!");
////            request.setAttribute("name", "");
////            request.setAttribute("errorBean", eb);
////            error+=eb.getError();
////            url =  request.getContextPath() + "/pizza-gh-pages/pizza-gh-pages/changeInformation.jsp";
////            response.sendRedirect(url + "?error=" + URLEncoder.encode(eb.getError(), "UTF-8"));
////            return;
////
////        }
//        //kiem tra sdt co hop le khong
//
//
//        if((phoneNumber.length()!=10)||!phoneNumber.startsWith("0")) {
//            error+="số điện thoại nhập vào không hợp lệ, vui lòng nhập bắt đầu từ số 0 và gồm 10 chữ số!";
//            request.setAttribute("Error", error);
//            eb = new ErrorBean();
//            eb.setError((String)request.getAttribute("Error"));
//            request.setAttribute("errorBean", eb);
//            url = request.getContextPath() + "/WEB-INF/book/changeInformation.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//            return;
//        }
//        try {
//            // Chuyển chuỗi thành đối tượng Date
//            date =dateFormat.parse(birthday);
//            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//            user.setBirthday(sqlDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//
//        if(user!=null) {
//
//            url = "/WEB-INF/book/index.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//        }else {
//            request.setAttribute("Error", error);
//
//            eb.setError((String)request.getAttribute("Error"));
//            request.setAttribute("errorBean", eb);
//            url = request.getContextPath() + "/WEB-INF/book/changeInformation.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//            return;
//        }

    }



            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                System.out.println("start ");
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");

                User user =(User) request.getSession().getAttribute("userC");
                System.out.println("id: "+user.getUserId());
                String sexual = request.getParameter("gender");
                System.out.println("gender: "+sexual);
                String birthday = request.getParameter("birthday");
                String phoneNumber = request.getParameter("phoneNumber");
                String email = request.getParameter("email");
                java.util.Date date=null;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

                UserDAO userDAO = new UserDAO(request);

                System.out.println(user);
                ErrorBean eb = new ErrorBean();
                String url = "";
                String error = "";

                if (user != null) {

                    if(userDAO.selectByEmail(email)&&!user.getEmail().equals(email)) {
                        request.setAttribute("Error", "ten email da ton tai, vui long chon email khac!");
                        eb.setError((String) request.getAttribute("Error"));
                        request.setAttribute("errorBean", eb);
                        url = request.getContextPath() + "/WEB-INF/book/changePassword.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);

                   return;

               }
                    if((phoneNumber.length()!=10)||!phoneNumber.startsWith("0")) {
                        request.setAttribute("Error", "số điện thoại nhập vào không hợp lệ, vui lòng nhập bắt đầu từ số 0 và gồm 10 chữ số!");
                        eb.setError((String) request.getAttribute("Error"));
                        request.setAttribute("errorBean", eb);
                        url = request.getContextPath() + "/WEB-INF/book/changePassword.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);

                        return;
        }


                    user.setEmail(email);
                    user.setSexual(sexual);
                    user.setPhone(phoneNumber);
                    try {
                        date =dateFormat.parse(birthday);
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        user.setBirthday(sqlDate);
                    } catch (ParseException e) {
                        System.out.println("loi ngay");
                        throw new RuntimeException(e);

                    }


                    userDAO.update(user);
                    url = "/WEB-INF/book/index.jsp";
                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("Error", "Vui long dang nhap de sua thong tin ca nhan!");

                    eb.setError((String) request.getAttribute("Error"));
                    request.setAttribute("errorBean", eb);
                    url = request.getContextPath() + "/WEB-INF/book/changePassword.jsp";
                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                    return;

                }

        }

}
