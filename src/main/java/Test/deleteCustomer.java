package Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteCustomer", value = "/deleteCustomer")
public class deleteCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          int id = Integer.parseInt(request.getParameter("id"));
          new CustomerDAO().delete(id);
          System.out.println("id"+id);
        request.getRequestDispatcher("/WEB-INF/admin/jsp/ListCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}