package controller.user;

import database.OrderDAO;
import database.OrderDetailDAO;
import database.PaymentDAO;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CheckoutController", value = "/CheckoutController")
public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String address = request.getParameter("address");
        String note = request.getParameter("note");
        String phone = request.getParameter("phone");
        String name = request.getParameter("nameConsignee");
        String paymentIdString = request.getParameter("payment");
        int paymentId = Integer.parseInt(paymentIdString);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userC");

        // Kiểm tra đăng nhập
        if (user == null) {
            String url = request.getContextPath() + "/WEB-INF/book/logintwo.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request,response);
            return; // Dừng xử lý tiếp theo
        }


        // Lấy giỏ hàng từ session
        Cart cart = (Cart) session.getAttribute("cart");

        // Tạo đối tượng Order từ thông tin trong session
        OrderDAO orderDAO = new OrderDAO();
        java.sql.Date currentTime = new java.sql.Date(System.currentTimeMillis());
        PaymentDAO paymentDAO = new PaymentDAO();
        Payment payment = paymentDAO.selectById(paymentId);
        Order order = new Order(orderDAO.creatId() + 1, user, cart.calculateTotal(), name, phone, address, payment, "Pending", currentTime, note);

        // Insert vào CSDL
        order.setNameConsignee(name);
        order.setUser(user);
        order.setPhone(phone);
        order.setAddress(address);
        order.setNote(note);
        session.setAttribute("order", order);
        int resultOrder = orderDAO.insert(order);

        // Xử lý kết quả insert
        if (resultOrder > 0) {
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            int overallResult = 1;
            for (CartItem cartItem : cart.getCart_items()) {
                Product product = cartItem.getProduct();
                int quantity = cartItem.getQuantity();
                double price = cartItem.getPrice();
                double totalPrice = quantity * price;
                OrderDetail orderDetail = new OrderDetail(orderDetailDAO.creatId()+1,order, product, quantity, totalPrice);
                int resultOrderDetail = orderDetailDAO.insert(orderDetail);

                List<OrderDetail> orderDetailList = (List<OrderDetail>) session.getAttribute("orderDetails");
                if (orderDetailList == null) {
                    orderDetailList = new ArrayList<>();
                }
                orderDetailList.add(orderDetail);
                session.setAttribute("orderDetails", orderDetailList);

                if (resultOrderDetail <= 0) {
                    overallResult = resultOrder;
                    break;
                }
            }
            if(overallResult > 0){
                // Xóa giỏ hàng sau khi đặt hàng thành công
                cart.clearCart();
                // Chuyển hướng đến trang xác nhận đơn hàng
                String url = request.getContextPath() + "/WEB-INF/book/thankyou.jsp";
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request,response);
                return; // Dừng xử lý tiếp theo
            }
        }

    }

}