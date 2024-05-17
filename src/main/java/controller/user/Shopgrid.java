package controller.user;

import database.CategoryDAO;
import database.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Shopgrid", value = "/Shopgrid")
public class Shopgrid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //list danh sach cua the loai sach
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<Category> categories =categoryDAO.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("list",categories);
        //list danh sach cua san pham
        ProductDAO productDAO = new ProductDAO();
        ArrayList<Product> products = productDAO.selectAll();

        int page, numpage = 12;
        int size = products.size();
        int num = (size % numpage == 0) ? (size / numpage) : ((size / numpage) + 1);
        String xpage = request.getParameter("page");

        if (xpage == null || xpage.isEmpty()) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        int start = (page - 1) * numpage;
        int end = Math.min(page * numpage, size);
        List<Product> list = productDAO.getListByPage(products, start, end);

        session.setAttribute("listProduct", list);
        session.setAttribute("listProducts", products);
        session.setAttribute("page", page);
        session.setAttribute("num", num);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book/shop-grid.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}