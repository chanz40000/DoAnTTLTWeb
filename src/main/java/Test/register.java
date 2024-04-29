package Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password= request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        Customer customer = new Customer(id, name, username, email, password, gender);
        new CustomerDAO().insert(customer);

        System.out.println(id+"-"+name+"-"+username+"-"+password+"-"+email+"-"+gender);
        request.getRequestDispatcher("/WEB-INF/admin/jsp/ListCustomer.jsp").forward(request, response);


    }
}