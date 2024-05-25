package controller.user;

import database.OrderDAO;
import database.OrderHistoryDAO;
import model.Order;
import model.OrderHistory;
import model.StatusOrder;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "ChangeStatusOrderUser", value = "/ChangeStatusOrderUser")
public class ChangeStatusOrderUser extends HttpServlet {
    OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
    OrderDAO orderDAO = new OrderDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userC");
        String orderIdString = request.getParameter("orderId");
        int orderId = Integer.parseInt(orderIdString);
        String action = request.getParameter("action");
        String reason = request.getParameter("reason");

        StatusOrder dongGoi = new StatusOrder(2);
        StatusOrder daNhan = new StatusOrder(10);
        StatusOrder yeuCauHuy = new StatusOrder(5);
        StatusOrder huyDonHang = new StatusOrder(6);
        StatusOrder traHang = new StatusOrder(7);


        if ("CancelOrder1".equals(action)) {
            // huy don hang khi trong trang thai dang cho admin xac nhan don hang
            updateOrderStatus(orderId, huyDonHang, user, reason);
        } else if ("CancelOrder2".equals(action)) {
            // huy don hang khi trong trang thai dang dong goi va cho admin xac nhan yeu cau huy
            updateOrderStatus(orderId, yeuCauHuy, user, reason);
        } else if ("ReturnCancelOrder2".equals(action)) {
            // Huy yeu cau huy don neu admin chua xac nhan yeu cau huy don do
            String reasonReturn = "Hủy yêu cầu hủy đơn";
            updateOrderStatus(orderId, dongGoi, user, reasonReturn);
        } else if ("ReceiveOrder".equals(action)) {
            String reasonReturn = "Khách hàng đã xác nhận nhận hàng thành công";
            updateOrderStatus(orderId, daNhan, user, reasonReturn);
        } else if ("ReturnOrder".equals(action)) {
            // khach hang yeu cau tra hang
            updateOrderStatus(orderId, traHang, user, reason);
        } else if ("CancelReturnOrder".equals(action)) {
            String reasonReturn = "Khách hàng đã hủy yêu cầu trả hàng";
            updateOrderStatus(orderId, daNhan, user, reasonReturn);
        }
        request.setAttribute("action", action);
        response.sendRedirect(request.getContextPath() + "/Order");
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
}