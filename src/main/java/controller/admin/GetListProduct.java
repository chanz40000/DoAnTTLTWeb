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
//        ArrayList<Product> products = productDAO.selectAll();
        ArrayList<Product> list = productDAO.selectAll();

        HttpSession session = request.getSession();
        int page, numpage = 12;
        int size = list.size();
        int num = (size % numpage == 0) ? (size / numpage) : ((size / numpage) + 1);
        String xpage = request.getParameter("page");

        if (xpage == null || xpage.isEmpty()) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        int start = (page - 1) * numpage;
        int end = Math.min(page * numpage, size);
        ArrayList<Product> products = productDAO.getListByPage(list, start, end);


        session.setAttribute("listProduct", list);
//        session.setAttribute("listProducts", products);
        session.setAttribute("page", page);
        session.setAttribute("num", num);

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