package controller.user;

import database.CommentDAO;
import database.ProductDAO;
import database.RatingDAO;
import model.Comment;
import model.Product;
import model.Rating;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CommentRating", value = "/CommentRating")
public class CommentRating extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productid = Integer.parseInt(request.getParameter("productid"));
        Product pr = new ProductDAO().selectById(productid);

        int ratingid = Integer.parseInt(request.getParameter("ratingid"));
        Rating ra = new RatingDAO().selectById(ratingid);
        String comment = request.getParameter("detailcomment");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        long dateRating = date.getTime() / 1000; // Convert Date to Unix timestamp
        CommentDAO commentDAO = new CommentDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userC");
        Comment co = new Comment(commentDAO.creatId()+1,ratingid,pr,user,comment,dateRating);
        commentDAO.insert(co);



        response.sendRedirect(request.getContextPath() + "/Shopdetails?id=" + productid);

    }
}