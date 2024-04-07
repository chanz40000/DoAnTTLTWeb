package controller.user;

import database.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FilterCategory", value = "/FilterCategory")
public class FilterCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryname = request.getParameter("caname");


        ProductDAO proDao = new ProductDAO();
        ArrayList<Product> arr = proDao.selectByCategoryName(categoryname);

        HttpSession session = request.getSession();
        session.setAttribute("listProduct", arr);
        String url = "/WEB-INF/book/.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}