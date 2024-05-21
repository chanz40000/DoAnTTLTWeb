package controller.admin;

import com.google.gson.Gson;
import database.OrderDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RevenueDataServlet", value = "/RevenueDataServlet")
public class RevenueDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO orderDAO = new OrderDAO();
       double[] revenueData = orderDAO.revenue2(2024);
        double[] revenueData2 = {28, 68, 40, 19, 96};

        // Convert list to JSON
        Gson gson = new Gson();
        String json = gson.toJson(revenueData);
        String json2 = gson.toJson(revenueData2);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        response.getWriter().write(json2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}