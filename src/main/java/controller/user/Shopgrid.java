package controller.user;

import database.CategoryDAO;
import database.ProductDAO;
import database.RatingDAO;
import model.Category;
import model.Product;
import util.EHCacheUtil;

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
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<Category> categories = categoryDAO.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("list", categories);

        ProductDAO productDAO = new ProductDAO();
        RatingDAO raDao = new RatingDAO();

        String category = request.getParameter("category");
        String xpage = request.getParameter("page");
        int page = (xpage == null || xpage.isEmpty()) ? 1 : Integer.parseInt(xpage);

        // Tạo khóa cho bộ nhớ đệm
        String cacheKey = (category != null ? category : "all") + "-" + page;

        // Kiểm tra bộ nhớ đệm
        ArrayList<Product> products = (ArrayList<Product>) EHCacheUtil.get(cacheKey);

        // Nếu bộ nhớ đệm không có dữ liệu, truy vấn cơ sở dữ liệu và lưu vào bộ nhớ đệm
        if (products == null) {
            if (category != null && !category.isEmpty()) {
                products = productDAO.selectByCategoryName(category);
            } else {
                products = productDAO.selectAll();
            }
            EHCacheUtil.set(cacheKey, products);
        }

        int numpage = 12;
        int size = products.size();
        int num = (size % numpage == 0) ? (size / numpage) : ((size / numpage) + 1);
        int start = (page - 1) * numpage;
        int end = Math.min(page * numpage, size);
        List<Product> list = productDAO.getListByPage(products, start, end);

        session.setAttribute("listProduct", list);
        session.setAttribute("listProducts", products);
        session.setAttribute("page", page);
        session.setAttribute("num", num);
        session.setAttribute("selectedCategory", category);

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            response.setContentType("application/json");
            // Return JSON if needed
        } else if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            request.getRequestDispatcher("/WEB-INF/book/shop-grid.jsp").forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book/shop-grid.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
