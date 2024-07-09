package controller.admin;

import database.ChangePriceDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteProductChangePrice", value = "/DeleteProductChangePrice")
public class DeleteProductChangePrice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User auth = (User) request.getSession().getAttribute("admin");
        if (auth == null) {
            // User not authenticated, redirect to the login page
            response.sendRedirect("Login");
            return; // Stop further processing
        }
        StringBuilder itemId = new StringBuilder();
        for(String proid:request.getParameterValues("selectedItem")) {
            itemId.append("").append(proid).append(",");
        }
        itemId.deleteCharAt(itemId.length()-1);
        String id = itemId.toString();
        id.replace("'", "");
        int itemId2 = Integer.parseInt(id);
        ChangePriceDAO dao = new ChangePriceDAO();
        dao.delete(itemId2);
        response.sendRedirect("ChangePrice");
    }
}