/**
 * 
 */
package Filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ErrorBean;
import model.User;


/**
 * 
 */
//Nó chủ yếu được sử dụng để thực hiện các tác vụ lọc như chuyển đổi, ghi nhật ký, nén, mã hóa và giải mã, xác thực đầu vào, v.v.
public class AuthorizationFilter implements Filter{

	private ServletContext context;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//Filter.super.destroy();
	}

	// Được bộ chứa web gọi để cho bộ lọc biết rằng nó đang được đưa vào sử dụng.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = filterConfig.getServletContext();
	}

	//thực hiện logic kiểm tra quyền truy cập.
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String url = request.getRequestURI();
		ErrorBean eb = new ErrorBean();
	
		
		if(url.contains("/admin")) {
			User admin = (User) request.getSession().getAttribute("admin");
			if(admin!=null) {
				filterChain.doFilter(servletRequest, servletResponse);
			}else {

				request.setAttribute("Error", "Vui long dang nhap vao tai khoan admin!");
				eb.setError((String) request.getAttribute("Error"));
				request.setAttribute("errorBean", eb);
				url = request.getContextPath() + "/WEB-INF/book/login.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
	               return;
			}
		}else
		
		if(url.contains("/ChangeInf")||url.contains("/ChangePass")||url.contains("/Profile")) {
			User customer = (User) request.getSession().getAttribute("userC");
			if(customer!=null) {
				filterChain.doFilter(servletRequest, servletResponse);
			}else {
				request.setAttribute("Error", "Vui long dang nhap vao tai khoan nguoi dung de thuc hien!");
				eb.setError((String) request.getAttribute("Error"));
				request.setAttribute("errorBean", eb);
				url = request.getContextPath() + "/Login";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				return;
			}
		}
		else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
		
	}

}
