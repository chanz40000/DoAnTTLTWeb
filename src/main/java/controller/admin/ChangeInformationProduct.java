package controller.admin;

import database.CategoryDAO;
import database.ProductDAO;
import database.UserDAO;
import model.Category;
import model.Product;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ChangeInformationProduct", value = "/ChangeInformationProduct")
public class ChangeInformationProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("start ");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("start ");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        String name = request.getParameter("name");
        String categoryName = request.getParameter("category");
        String author = request.getParameter("author");
        String publicationYear = request.getParameter("publicationYear");
        String description = request.getParameter("description");
        String unitPrice = request.getParameter("unitPrice");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String image = request.getParameter("image");
        String publisher = request.getParameter("publisher");

        Category category = new CategoryDAO().selectByName(categoryName);


        ProductDAO productDAO = new ProductDAO(request);
        Product product = new Product(Integer.parseInt(id), name, description,
                image, Double.parseDouble(unitPrice), Double.parseDouble(price),
                Integer.parseInt(quantity), author, Integer.parseInt(publicationYear), publisher, category );

        int update = productDAO.update(product);
        String url = request.getContextPath() + "/WEB-INF/admin/jsp/listProduct.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request,response);
//        request.getRequestDispatcher("/WEB-INF/admin/jsp/listProduct.jsp").forward(request,response);

    }
}