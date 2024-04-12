package controller.user;

import database.ProductDAO;
import model.Product;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Shopdetails", value = "/Shopdetails")
public class Shopdetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User auth = (User) request.getAttribute("userC");
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO proDao = new ProductDAO();
        Product pro = proDao.selectById(id);
        int samecategory = proDao.selectCategoryId(id);
        List<Product> arr = proDao.selectSameCategory(samecategory,id);
        HttpSession session = request.getSession();
        request.setAttribute("detail",pro);
        request.setAttribute("proCa",arr);
        String url = "/WEB-INF/book/shop-details.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}