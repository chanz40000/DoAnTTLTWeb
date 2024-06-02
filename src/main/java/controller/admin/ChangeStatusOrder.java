package controller.admin;

import database.OrderDAO;
import database.OrderDetailDAO;
import database.OrderHistoryDAO;
import database.StatusOrderDAO;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "ChangeStatusOrder", value = "/ChangeStatusOrder")
public class ChangeStatusOrder extends HttpServlet {
    OrderDAO orderDAO = new OrderDAO();
    OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("admin");
        String orderIdString = request.getParameter("orderId");
        int orderId = Integer.parseInt(orderIdString);
        String action = request.getParameter("action");
        String reason = "";
        StatusOrder newStatus = null;
        String nextAction = ""; // add next action

        if ("AcceptOrder".equals(action)) {
            newStatus = new StatusOrder(2, "Đang được đóng gói");
            reason = "Đồng ý đơn hàng";
            nextAction = "Packed";
        } else if ("RejectOrder".equals(action)) {
            newStatus = new StatusOrder(6, "Đã hủy");
            reason = "Gặp sự cố! Xin lỗi quý khách vì vấn đề này, mong bạn thông cảm và bỏ qua cho chúng tôi.";
        } else if ("Packed".equals(action)) {
            newStatus = new StatusOrder(3, "Đang giao hàng");
            reason = "Đơn hàng đã được đóng gói và đang được vận chuyển.";
            nextAction = "Delivering";
            scheduleStatusUpdate(orderId);
        } else if ("Cancel".equals(action)) {
            newStatus = new StatusOrder(6, "Đã hủy");
            reason = "Đơn hàng đã được chấp nhận hủy.";
        } else if ("RejectCancelOrder".equals(action)) {
            newStatus = new StatusOrder(2, "Đang được đóng gói");
            reason = "Admin từ chối yêu cầu hủy đơn.";
            nextAction = "Packed";
        } else if ("AcceptReturnOrder".equals(action)) {
            newStatus = new StatusOrder(8, "Đã hoàn");
            reason = "Đơn hàng đã được chấp nhận hoàn.";
        } else if ("RejectReturnOrder".equals(action)) {
            newStatus = new StatusOrder(10, "Đã nhận");
            reason = "Admin từ chối yêu cầu hoàn đơn.";
        }

        if (newStatus != null) {
            updateOrderStatus(orderId, newStatus, user, reason);

            PrintWriter out = response.getWriter();
            String jsonResponse = "{\"success\": true, \"newStatus\": \"" + newStatus.getStatusName() + "\", \"nextAction\": \"" + nextAction + "\", \"user\": \"" + user.getUserId() + "\"}";
            System.out.println("Sending JSON response: " + jsonResponse);
            out.print(jsonResponse);
            out.flush();
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            PrintWriter out = response.getWriter();
            String jsonResponse = "{\"success\": false}";
            System.out.println("Sending JSON response: " + jsonResponse);
            out.print(jsonResponse);
            out.flush();
        }
    }

    private void updateOrderStatus(int orderId, StatusOrder status, User user, String reason) {
        orderDAO.updateStatusOrder(orderId, status);
        Order order = orderDAO.selectById(orderId);
        OrderHistory orderHistory = new OrderHistory(orderHistoryDAO.creatId() + 1, order, user, status, LocalDateTime.now(), reason);
        orderHistoryDAO.insert(orderHistory);
    }

    private void scheduleStatusUpdate(int orderId) {
        StatusOrder giaoThanhCong = new StatusOrder(4, "Giao thành công");
        String reason = "Đơn hàng đã giao thành công.";

        scheduler.schedule(() -> {
            orderDAO.updateStatusOrder(orderId, giaoThanhCong);
            Order order = orderDAO.selectById(orderId);
            order.setStatus(giaoThanhCong);
            OrderHistory orderHistory = new OrderHistory(orderHistoryDAO.creatId() + 1, order, giaoThanhCong, LocalDateTime.now(), reason);
            orderHistoryDAO.insert(orderHistory);
        }, 1, TimeUnit.MINUTES);
    }
}