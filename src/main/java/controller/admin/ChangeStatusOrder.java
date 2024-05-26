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
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("admin");
        String orderIdString = request.getParameter("orderId");
        int orderId = Integer.parseInt(orderIdString);
        String action = request.getParameter("action");
        String reason = "";
        StatusOrder xacNhanDonHang = new StatusOrder(2);
        StatusOrder dangVanChuyen = new StatusOrder(3);
        StatusOrder huyDonHang = new StatusOrder(6);
        StatusOrder hoanDon = new StatusOrder(8);
        StatusOrder daNhan = new StatusOrder(10);
        if ("AcceptOrder".equals(action)){
            // Dong y don hang
            reason = "Đồng ý đơn hàng";
            updateOrderStatus(orderId, xacNhanDonHang, user, reason);
        } else if ("RejectOrder".equals(action)) {
            // Huy don hang
            reason = "Gặp sự cố! Xin lỗi quý khách vì vấn đề này, mong bạn thông cảm và bỏ qua cho chúng tôi.";
            updateOrderStatus(orderId, huyDonHang, user, reason);
        } else if ("Packed".equals(action)) {
            // Da dong goi don hang
            reason = "Đơn hàng đã được đóng gói và đang được vận chuyển.";
            updateOrderStatus(orderId, dangVanChuyen, user, reason);
            // Sau mot thoi gian thi don hang tu set trang thai da giao thanh cong
            scheduleStatusUpdate(orderId);
        } else if ("Cancel".equals(action)) {
            // Admin chap nhan yeu cau huy don cua khach hang
            reason = "Đơn hàng đã được chấp nhận hủy.";
            updateOrderStatus(orderId, huyDonHang, user, reason);
        } else if ("RejectCancelOrder".equals(action)) {
            // Admin tu choi yeu cau huy don cua khach hang
            reason = "Admin từ chối yêu cầu hủy đơn.";
            updateOrderStatus(orderId, xacNhanDonHang, user, reason);
        } else if ("AcceptReturnOrder".equals(action)) {
            // Admin dong y yeu cau tra hang cua khach hang
            reason = "Đơn hàng đã được chấp nhận hoàn.";
            updateOrderStatus(orderId, hoanDon, user, reason);
        } else if ("RejectReturnOrder".equals(action)) {
            // Admin tu choi yeu cau tra hang cua khach hang
            reason = "Admin từ chối yêu cầu hoàn đơn.";
            updateOrderStatus(orderId, daNhan, user, reason);
        }
        request.setAttribute("action", action);
        response.sendRedirect(request.getContextPath() + "/ListOrder");
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
