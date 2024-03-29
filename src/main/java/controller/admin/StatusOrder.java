package controller.admin;

import database.OrderDAO;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StatusOrder", value = "/StatusOrder")
public class StatusOrder extends HttpServlet {
    OrderDAO orderDAO = new OrderDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String orderIdString = request.getParameter("orderId");
        int orderId = Integer.parseInt(orderIdString);
        String action = request.getParameter("action");
        Order order = new Order();
        if("packing".equals(action)){
            orderDAO.updateStatusOrder(orderId, "Đang đóng gói");
            order.setStatus("Đang đóng gói");
        }else if("packed".equals(action)){
            orderDAO.updateStatusOrder(orderId, "Đã gửi cho đơn vị vận chuyển");
            order.setStatus("Đã gửi cho đơn vị vận chuyển");
        }else if("cancellation".equals(action)){
            orderDAO.updateStatusOrder(orderId, "Đã hủy");
            order.setStatus("Đã hủy");
        }
        request.setAttribute("order", order);
        request.setAttribute("action", action);
        String url = request.getContextPath() + "/WEB-INF/admin/jsp/listOrder.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request,response);
        }
}