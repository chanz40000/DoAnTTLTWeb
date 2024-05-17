package database;

import model.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends AbsDAO<Order>{
    private ArrayList<Order> data = new ArrayList<>();

    public OrderDAO(HttpServletRequest request) {
        super(request);
    }

    public OrderDAO() {

    }

    public int creatId() {
        data = selectAll();
        return data.size();
    }
    @Override
    public ArrayList<Order> selectAll() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM orders";

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idImport = rs.getInt("order_id");
                int idUser = rs.getInt("user_id");
                double totalPrice = rs.getDouble("total_price");
                String userConsignee = rs.getString("nameConsignee");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int idPayment = rs.getInt("payment_id");
                Date dateO = rs.getDate("booking_date");
                String note = rs.getString("note");
                double shippingFee = rs.getDouble("shipping_fee");
                int status = rs.getInt("status_id");
                User u = new UserDAO().selectById(idUser);
                Payment pay = new PaymentDAO().selectById(idPayment);
                StatusOrder statusOrder = new StatusOrderDAO().selectById(status);
                Order order = new Order(idImport,u,totalPrice,userConsignee,phone,address,pay,dateO,note,shippingFee,statusOrder);


                orders.add(order);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;

    }
    public List<Order> selectOrderByStatus(int status){
        List<Order> orders = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM orders WHERE status_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, status);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int idImport = rs.getInt("order_id");
                int idUser = rs.getInt("user_id");
                double totalPrice = rs.getDouble("total_price");
                String userConsignee = rs.getString("nameConsignee");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int idPayment = rs.getInt("payment_id");
                Date dateO = rs.getDate("booking_date");
                String note = rs.getString("note");
                double shippingFee = rs.getDouble("shipping_fee");
                int statusId = rs.getInt("status_id");
                User u = new UserDAO().selectById(idUser);
                Payment pay = new PaymentDAO().selectById(idPayment);
                StatusOrder statusOrder = new StatusOrderDAO().selectById(status);
                Order order = new Order(idImport,u,totalPrice,userConsignee,phone,address,pay,dateO,note,shippingFee,statusOrder);
                orders.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }
    public void updateStatusOrder(int orderId, StatusOrder status){
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE orders SET status_id = ? WHERE order_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, status.getStatusId());
            st.setInt(2, orderId);
            result = st.executeUpdate();
            OrderDAO orderDAO = new OrderDAO();
            Order order = orderDAO.selectById(orderId);
            this.setPreValue(this.gson.toJson(order));
            order.setStatus(status);
            this.setValue("change status: "+ status);
            int x = super.update(order);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public Order selectById(int id) {
        Order result = null;

        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM orders WHERE order_id =?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idImport = rs.getInt("order_id");
                int idUser = rs.getInt("user_id");
                double totalPrice = rs.getDouble("total_price");
                String userConsignee = rs.getString("nameConsignee");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int idPayment = rs.getInt("payment_id");
                Date dateO = rs.getDate("booking_date");
                String note = rs.getString("note");
                double shippingFee = rs.getDouble("shipping_fee");
                int status = rs.getInt("status_id");
                User u = new UserDAO().selectById(idUser);
                Payment pay = new PaymentDAO().selectById(idPayment);
                StatusOrder statusOrder = new StatusOrderDAO().selectById(status);
                result= new Order(idImport,u,totalPrice,userConsignee,phone,address,pay,dateO,note,shippingFee,statusOrder);


            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
    public Order selectByUserId(int id) {
        Order result = null;

        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM orders WHERE user_id =?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idImport = rs.getInt("order_id");
                int idUser = rs.getInt("user_id");
                double totalPrice = rs.getDouble("total_price");
                String userConsignee = rs.getString("nameConsignee");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int idPayment = rs.getInt("payment_id");
                Date dateO = rs.getDate("booking_date");
                String note = rs.getString("note");
                double shippingFee = rs.getDouble("shipping_fee");
                int status = rs.getInt("status_id");
                User u = new UserDAO().selectById(idUser);
                Payment pay = new PaymentDAO().selectById(idPayment);
                StatusOrder statusOrder = new StatusOrderDAO().selectById(status);
                result= new Order(idImport,u,totalPrice,userConsignee,phone,address,pay,dateO,note,shippingFee,statusOrder);


            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
    public Order selectByUserIdAndStatusId(int userId, int statusId) {
        Order result = null;

        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM orders WHERE user_id = ? AND status_id = ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, statusId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idImport = rs.getInt("order_id");
                int idUser = rs.getInt("user_id");
                double totalPrice = rs.getDouble("total_price");
                String userConsignee = rs.getString("nameConsignee");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int idPayment = rs.getInt("payment_id");
                Date dateO = rs.getDate("booking_date");
                String note = rs.getString("note");
                double shippingFee = rs.getDouble("shipping_fee");
                int status = rs.getInt("status_id");
                User u = new UserDAO().selectById(idUser);
                Payment pay = new PaymentDAO().selectById(idPayment);
                StatusOrder statusOrder = new StatusOrderDAO().selectById(status);
                result= new Order(idImport,u,totalPrice,userConsignee,phone,address,pay,dateO,note,shippingFee,statusOrder);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
    @Override
    public int insert(Order order) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO orders(order_id, user_id,total_price,nameConsignee,phone,address,payment_id,booking_date,note,shipping_fee,status_id)"
                    + "VALUE(?, ?, ?, ?,?,?,?,?,?,?,?)";

            PreparedStatement rs = con.prepareStatement(sql);

            rs.setInt(1, order.getOrderId());
            rs.setInt(2, order.getUser().getUserId());
            rs.setDouble(3, order.getTotalPrice());
            rs.setString(4, order.getNameConsignee());
            rs.setString(5, order.getPhone());
            rs.setString(6, order.getAddress());
            rs.setDouble(7, order.getPayment().getPaymentId());
            rs.setDate(8, order.getBookingDate());
            rs.setString(9, order.getNote());
            rs.setDouble(10, order.getShippingFee());
            rs.setInt(11,order.getStatus().getStatusId());



            result = rs.executeUpdate();

            JDBCUtil.closeConnection(con);
            this.setPreValue(this.gson.toJson(order));
            int x = super.insert(order);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;

    }

    @Override
    public int insertAll(ArrayList<Order> list) {
        int result = 0;
        for (Order o : list) {

            ;
            if (this.insert(o) == 1)
                result += 1;
        }
        return result;
    }

    @Override
    public int delete(Order order) {
        int result = 0;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE from orders " + "WHERE order_id=?";

            PreparedStatement rs = con.prepareStatement(sql);
            rs.setInt(1, order.getOrderId());

            result = rs.executeUpdate();
            this.setPreValue(this.gson.toJson(order));
            int x = super.delete(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int deleteAll(ArrayList<Order> list) {
        int result = 0;

        for (Order o : list) {
            result += delete(o);
        }
        return result;
    }

    @Override
    public int update(Order order) {
        int result = 0;
        Order oldRating = this.selectById(order.getOrderId());

        if (oldRating != null) {

            try {
                Connection con = JDBCUtil.getConnection();

                String sql = "UPDATE orders SET user_id=? " +
                        ", total_price=? " +
                        ", nameConsignee=? " +
                        ", phone=? " +
                        ", address=? " +
                        ", payment_id=? " +
                        ", booking_date=? " +
                        ", note=? " +
                        ", shipping_fee=? " +
                        ", status_id=? " +
                        "WHERE order_id = ?";

                PreparedStatement rs = con.prepareStatement(sql);

                rs.setInt(1, order.getOrderId());
                rs.setInt(2, order.getUser().getUserId());
                rs.setDouble(3, order.getTotalPrice());
                rs.setString(4, order.getNameConsignee());
                rs.setString(5, order.getPhone());
                rs.setString(6, order.getAddress());
                rs.setDouble(7, order.getPayment().getPaymentId());
                rs.setDate(8, order.getBookingDate());
                rs.setString(9, order.getNote());
                rs.setDouble(10, order.getShippingFee());
                rs.setInt(11,order.getStatus().getStatusId());




                result = rs.executeUpdate();
                this.setPreValue(this.gson.toJson(oldRating));
                this.setValue(this.gson.toJson(order));
                int x = super.insert(order);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return result;
    }
    //tinh doanh thu theo ngay
    public double revenue(Date date){
        double result =0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT SUM(quantity*price) AS tongtien\n" +
                    "FROM orders a JOIN orderdetails b ON a.order_id=b.order_id\n" +
                    "WHERE a.booking_date=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setDate(1, date);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                result = rs.getDouble("tongtien");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    //doanh thu tu ngay n1 den ngay n2
    public double revenue(Date date1, Date date2){
        double result =0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT SUM(quantity*price) AS tongtien\n" +
                    "FROM orders a JOIN orderdetails b ON a.order_id=b.order_id\n" +
                    "WHERE a.booking_date>=? AND a.booking_date<=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setDate(1, date1);
            pre.setDate(2, date2);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                result = rs.getDouble("tongtien");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    //doanh thu theo thang
    public double revenue(int month, int year){
        double result =0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT \n" +
                    "    SUM(b.quantity * b.price) AS tongtien\n" +
                    "FROM \n" +
                    "    orders a\n" +
                    "JOIN \n" +
                    "    orderdetails b ON a.order_id = b.order_id\n" +
                    "WHERE \n" +
                    "    YEAR(a.booking_date) = ? AND MONTH(a.booking_date) = ?;\n";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, year);
            pre.setInt(2, month);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                result = rs.getDouble("tongtien");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    //doanh thu theo nam
    public double revenue( int year){
        double result =0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT \n" +
                    "    SUM(b.quantity * b.price) AS tongtien\n" +
                    "FROM \n" +
                    "    orders a\n" +
                    "JOIN \n" +
                    "    orderdetails b ON a.order_id = b.order_id\n" +
                    "WHERE \n" +
                    "    YEAR(a.booking_date) = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, year);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                result = rs.getDouble("tongtien");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        System.out.println(orderDAO.revenue(Date.valueOf(LocalDateTime.now().toLocalDate())));
    }

}