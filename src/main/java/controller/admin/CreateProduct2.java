package controller.admin;

import database.CategoryDAO;
import database.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateProduct2", value = "/CreateProduct2")
public class CreateProduct2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("start ");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("product_name");
        System.out.println("product_name"+name);
        String categoryName = request.getParameter("category");
        System.out.println("category"+categoryName);
        String author = request.getParameter("author");
        System.out.println("author"+author);
        String publicationYear = request.getParameter("publicationYear");
        System.out.println("publicationYear"+publicationYear);
        String description = request.getParameter("description");
        System.out.println("description"+description);
        //String unitPrice = request.getParameter("unitPrice");
        //String price = request.getParameter("price");
        //String quantity = request.getParameter("quantity");
        String image = request.getParameter("image");
        System.out.println("image"+image);
        String publisher = request.getParameter("publisher");
        System.out.println("publisher"+publisher);

        Category category = new CategoryDAO().selectByName(categoryName);


        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(productDAO.creatId()+1, name, description,
                "img1.jpg", 0, 0,
                0, author, Integer.parseInt(publicationYear), publisher, category );

        productDAO.insert(product);
        System.out.println("done");
        request.getRequestDispatcher("/WEB-INF/admin/jsp/listProduct.jsp").forward(request,response);

    }
}