package controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.*;
import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
        String fullNameTinh = request.getParameter("tinh");
        String fullNameQuan = request.getParameter("quan");
        String fullNamePhuong = request.getParameter("phuong");
        OrderDAO orderdao = new OrderDAO();

        String address = request.getParameter("address");
        String fullAddress = fullNameTinh + ", " + fullNameQuan + ", " + fullNamePhuong + ", " + address;
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
            dispatcher.forward(request, response);
            return; // Dừng xử lý tiếp theo
        }


        // Lấy giỏ hàng từ session
        Cart cart = (Cart) session.getAttribute("cart");

        // Tạo đối tượng Order từ thông tin trong session
        OrderDAO orderDAO = new OrderDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        Payment payment = paymentDAO.selectById(paymentId);
        StatusOrder statusOrder = new StatusOrder(1);
        Order order = new Order(orderDAO.creatId() + 1, user, cart.calculateTotal(), name, phone, fullAddress, payment, new Timestamp(System.currentTimeMillis()), note, 0, statusOrder);

        // Insert vào CSDL
        order.setNameConsignee(name);
        order.setUser(user);
        order.setPhone(phone);
        order.setAddress(fullAddress);
        order.setNote(note);
        session.setAttribute("order", order);
        int resultOrder = orderDAO.insert(order);
        // them vao lich su cap nhat trang thai don hang
        OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
        OrderHistory orderHistory = new OrderHistory(orderHistoryDAO.creatId() + 1, order, user, new StatusOrder(1), LocalDateTime.now(), "Đặt hàng thành công");
        orderHistoryDAO.insert(orderHistory);
        // Xử lý kết quả insert
        if (resultOrder > 0) {
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            ProductDAO productDAO = new ProductDAO();
            int overallResult = 1;
            for (CartItem cartItem : cart.getCart_items()) {
                Product product = cartItem.getProduct();
                int quantityOrdered = cartItem.getQuantity();
                //giam so luong san pham trong kho
                int remainingQuantity = product.getQuantity() - quantityOrdered;int resultUpQuantity = productDAO.updateQuantityOrder(product.getProductId(), remainingQuantity);
                if (resultUpQuantity > 0) {
                    double price = cartItem.getPrice();
                    double totalPrice = quantityOrdered * price;
                    OrderDetail orderDetail = new OrderDetail(orderDetailDAO.creatId() + 1, order, product, quantityOrdered, totalPrice);
                    int resultOrderDetail = orderDetailDAO.insert(orderDetail);

                    List<OrderDetail> orderDetailList = (List<OrderDetail>) session.getAttribute("orderDetails");
                    if (orderDetailList == null) {
                        orderDetailList = new ArrayList<>();
                    }
                    orderDetailList.add(orderDetail);
                    session.setAttribute("orderDetails", orderDetailList);

                    if (resultOrderDetail <= 0) {
                        overallResult = resultOrderDetail;
                        break;
                    }
                }else{
                    overallResult = resultUpQuantity;
                    break;
                }
            }
            if (overallResult > 0) {
                // Xóa giỏ hàng sau khi đặt hàng thành công
                cart.clearCart();
                // Chuyển hướng đến trang xác nhận đơn hàng
                if (paymentId == 1) {
                    request.getRequestDispatcher("/WEB-INF/book/Vnpay.jsp").forward(request, response);


                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book/thankyou.jsp");
                    dispatcher.forward(request, response);
                    return; // Dừng xử lý tiếp theo
                }
            }
        }
        // Tạo ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Chuyển đối tượng Order thành chuỗi JSON
        String orderJson = objectMapper.writeValueAsString(order);

        // Lưu chuỗi JSON vào thuộc tính của request để sử dụng trong JSP hoặc gửi lại cho client
        request.setAttribute("orderJson", orderJson);
    }
}
