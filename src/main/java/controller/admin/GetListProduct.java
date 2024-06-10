package controller.admin;

import com.google.gson.Gson;
import database.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetListProduct", value = "/GetListProduct")
public class GetListProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        ArrayList<Product> products = productDAO.selectAll();

        // Chuyển đổi danh sách sản phẩm thành chuỗi JSON
        Gson gson = new Gson();
        String jsonProducts = gson.toJson(products);

        // Gửi phản hồi JSON về client
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonProducts);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}