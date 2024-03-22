package controller.user;

import database.ProductDAO;
import database.UserDAO;
import model.ErrorBean;
import model.Product;
import model.User;
import util.Email;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Search
 */
@WebServlet(name = "search", value = "/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String productName = request.getParameter("productName");

		ProductDAO productDAO = new ProductDAO();
		ArrayList<Product> listProductSearchByName = productDAO.selectByProductName(productName);
		System.out.println(listProductSearchByName.size()+"kich thuoc");

		session.setAttribute("listProductSearchByName", listProductSearchByName);

		session.setAttribute("searchKeyword", productName);
		// lay toan bo danh sach khi khong tim thay ket qua
		ArrayList<Product> products = productDAO.selectAll();

		int page, numpage = 6;
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
		session.setAttribute("page", page);
		session.setAttribute("num", num);

		// chuyen huong trang

		request.getRequestDispatcher("/WEB-INF/book/searchResultPage.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

}