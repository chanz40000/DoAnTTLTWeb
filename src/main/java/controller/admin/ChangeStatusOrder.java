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
import java.util.concurrent.TimeUnit;

@WebServlet(name = "ChangeStatusOrder", value = "/ChangeStatusOrder")
public class ChangeStatusOrder extends HttpServlet {
    OrderDAO orderDAO = new OrderDAO();
    OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();

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

        if ("AcceptOrder".equals(action)) {
            newStatus = new StatusOrder(2, "Đang được đóng gói"); // Set correct status name
            reason = "Đồng ý đơn hàng";
        } else if ("RejectOrder".equals(action)) {
            newStatus = new StatusOrder(6, "Đã hủy"); // Set correct status name
            reason = "Gặp sự cố! Xin lỗi quý khách vì vấn đề này, mong bạn thông cảm và bỏ qua cho chúng tôi.";
        } else if ("Packed".equals(action)) {
            newStatus = new StatusOrder(3, "Đang giao hàng"); // Set correct status name
            reason = "Đơn hàng đã được đóng gói và đang được vận chuyển.";
            scheduleStatusUpdate(orderId);
        } else if ("Cancel".equals(action)) {
            newStatus = new StatusOrder(6, "Đã hủy"); // Set correct status name
            reason = "Đơn hàng đã được chấp nhận hủy.";
        } else if ("RejectCancelOrder".equals(action)) {
            newStatus = new StatusOrder(2, "Đang được đóng gói"); // Set correct status name
            reason = "Admin từ chối yêu cầu hủy đơn.";
        } else if ("AcceptReturnOrder".equals(action)) {
            newStatus = new StatusOrder(8, "Đã hoàn"); // Set correct status name
            reason = "Đơn hàng đã được chấp nhận hoàn.";
        } else if ("RejectReturnOrder".equals(action)) {
            newStatus = new StatusOrder(10, "Đã nhận"); // Set correct status name
            reason = "Admin từ chối yêu cầu hoàn đơn.";
        }

        if (newStatus != null) {
            updateOrderStatus(orderId, newStatus, user, reason);

            // Sending JSON response
            PrintWriter out = response.getWriter();
            out.print("{\"success\": true, \"newStatus\": \"" + newStatus.getStatusName() + "\"}");
            out.flush();
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            PrintWriter out = response.getWriter();
            out.print("{\"success\": false}");
            out.flush();
        }
    }

    private void updateOrderStatus(int orderId, StatusOrder status, User user, String reason){
        // cap nhat trang thai don hang
        orderDAO.updateStatusOrder(orderId, status);
        // lay order theo id cua order do
        Order order = orderDAO.selectById(orderId);
        // luu vao lich su cap nhat trang thai don hang
        OrderHistory orderHistory = new OrderHistory(orderHistoryDAO.creatId() + 1, order, user, status, LocalDateTime.now(), reason);
        orderHistoryDAO.insert(orderHistory);
    }
    private void scheduleStatusUpdate(int orderId) {
        StatusOrder giaoThanhCong = new StatusOrder(4);
        String reason = "Đơn hàng đã giao thành công.";
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Thực hiện cập nhật trạng thái đơn hàng sau 1 phút
                orderDAO.updateStatusOrder(orderId, giaoThanhCong);
                Order order = orderDAO.selectById(orderId);
                order.setStatus(giaoThanhCong);
                OrderHistory orderHistory = new OrderHistory(orderHistoryDAO.creatId() + 1, order, giaoThanhCong, LocalDateTime.now(), reason);
                orderHistoryDAO.insert(orderHistory);
            }
        };

        // Lập lịch để chạy task sau mỗi 1 phút
        Timer timer = new Timer();
        long delay = TimeUnit.MINUTES.toMillis(1); // 1 phút
        timer.schedule(task, delay);
    }
}
