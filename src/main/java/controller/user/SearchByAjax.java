package controller.user;

import database.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import util.FormatCurrency;

@WebServlet(name = "SearchByAjax", value = "/SearchByAjax")
public class SearchByAjax extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        String productName = request.getParameter("productName");

        ProductDAO productDAO = new ProductDAO();
        ArrayList<Product> listProductSearchByName = productDAO.selectByProductName(productName);
        System.out.println(listProductSearchByName.size() + "kich thuoc");

        session.setAttribute("listProduct", listProductSearchByName);

        session.setAttribute("searchKeyword", productName);
        PrintWriter out = response.getWriter();
		for(Product p:listProductSearchByName){
			out.println("<div class=\"col-lg-4 col-md-6 col-sm-6\">\n" +
                    "                            <div class=\"product__item\">\n" +
                    "                                <div class=\"product__item__pic set-bg\" > <!--data-setbg=\"\"-->\n" +
                    "                                    <img src=\"img/image/" +p.getImage() + "\">\n" +
                    "                                    <ul class=\"product__item__pic__hover\">\n" +
                    "                                        <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n" +
                    "                                        <li><a href=\"Shopdetails?id= " +p.getProductId() + "\"><i class=\"fa fa-info-circle\"></i></a></li>\n" +
                    "                                        <li>\n" +
                    "                                            <form class=\"add-to-cart-form\" action=\"AddToCart\" method=\"post\" id=\"addToCartForm\">\n" +
                    "                                                <input type=\"hidden\" name=\"productId\" value=\"" + p.getProductId() + "\">\n" +
                    "                                                <button class=\"submit-button\" type=\"submit\">\n" +
                    "                                                    <a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a>\n" +
                    "                                                </button>\n" +
                    "                                            </form>\n" +
                    "                                        </li>\n" +
                    "                                    </ul>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"product__item__text\">\n" +
                    "                                    <h6><a href=\"#\">"+p.getProduct_name() +"\"</a></h6>\n" +
                    "                                    <ul class=\"Ratestar\">\n" +
                    "                                        <li><i class=\"fa fa-star\"></i></li>\n" +
                    "                                        <li><i class=\"fa fa-star\"></i></li>\n" +
                    "                                        <li><i class=\"fa fa-star\"></i></li>\n" +
                    "                                        <li><i class=\"fa fa-star\"></i></li>\n" +
                    "                                        <li><i class=\"fa fa-star\"></i></li>\n" +
                    "                                        <li class=\"Stick\"></li>\n" +
                    "                                    <li class=\"Productnotsell\">Còn lại 5</li>\n" +
                    "\n" +
                    "                                    </ul>\n" +
					"                                    <h5>"+ FormatCurrency.formatCurrency(p.getPrice()) + "</h5>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>");
		}
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}