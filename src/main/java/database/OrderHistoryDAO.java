package database;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderHistoryDAO implements DAOInterface<OrderHistory> {
    public int creatId() {
        return this.selectAll().size()+1;
    }
    @Override
    public ArrayList<OrderHistory> selectAll() {
        ArrayList<OrderHistory> orderHistories = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM orderHistory";

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("orderHistory_id");
                int orderId = rs.getInt("order_id");
                int userId = rs.getInt("user_id");
                int statusId = rs.getInt("status_id");
                Timestamp timestamp = rs.getTimestamp("date_updateStatus");
                LocalDateTime time = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                String reason = rs.getString("reason");
                Order order = new OrderDAO().selectById(orderId);
                User user = new UserDAO().selectById(userId);
                StatusOrder statusOrder = new StatusOrderDAO().selectById(statusId);
                OrderHistory orderHistory = new OrderHistory(id, order, user, statusOrder, time, reason);
                orderHistories.add(orderHistory);


            }

            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistories;
    }
    public OrderHistory selectLatestByOrderId(int orderId) {
        OrderHistory orderHistory = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM orderHistory WHERE order_id = ? ORDER BY date_updateStatus DESC LIMIT 1";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, orderId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("orderHistory_id");
                int userId = rs.getInt("user_id");
                int statusId = rs.getInt("status_id");
                Timestamp timestamp = rs.getTimestamp("date_updateStatus");
                LocalDateTime time = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                String reason = rs.getString("reason");
                Order order = new OrderDAO().selectById(orderId);
                User user = new UserDAO().selectById(userId);
                StatusOrder statusOrder = new StatusOrderDAO().selectById(statusId);
                orderHistory = new OrderHistory(id, order, user, statusOrder, time, reason);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public OrderHistory selectById(int id) {
        OrderHistory orderHistory = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM orderHistory WHERE orderHistory_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int orderId = rs.getInt("order_id");
                int userId = rs.getInt("user_id");
                int statusId = rs.getInt("status_id");
                Timestamp timestamp = rs.getTimestamp("date_updateStatus");
                LocalDateTime time = (timestamp != null) ? timestamp.toLocalDateTime() : null;
                String reason = rs.getString("reason");
                Order order = new OrderDAO().selectById(orderId);
                User user = new UserDAO().selectById(userId);
                StatusOrder statusOrder = new StatusOrderDAO().selectById(statusId);
                orderHistory = new OrderHistory(id, order, user, statusOrder, time, reason);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public int insert(OrderHistory orderHistory) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO orderHistory (orderHistory_id, order_id, user_id, status_id, date_updateStatus, reason) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, orderHistory.getOrderHistoryId());
            st.setInt(2, orderHistory.getOrder().getOrderId());
            // Kiểm tra nếu user là null, đặt giá trị null cho user_id
            if (orderHistory.getUser() != null) {
                st.setInt(3, orderHistory.getUser().getUserId());
            } else {
                st.setNull(3, java.sql.Types.INTEGER);
            }
            st.setInt(4, orderHistory.getStatusOrder().getStatusId());
            st.setTimestamp(5, Timestamp.valueOf(orderHistory.getTime()));
            st.setString(6, orderHistory.getReason());
            result = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insertAll(ArrayList<OrderHistory> list) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO orderHistory (orderHistory_id, order_id, user_id, status_id, date_updateStatus, reason) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            for (OrderHistory orderHistory : list) {
                st.setInt(1, orderHistory.getOrderHistoryId());
                st.setInt(2, orderHistory.getOrder().getOrderId());
                st.setInt(3, orderHistory.getUser().getUserId());
                st.setInt(4, orderHistory.getStatusOrder().getStatusId());
                st.setTimestamp(5, Timestamp.valueOf(orderHistory.getTime()));
                st.setString(6, orderHistory.getReason());
                result += st.executeUpdate();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(OrderHistory orderHistory) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM orderHistory WHERE orderHistory_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, orderHistory.getOrderHistoryId());
            result = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteAll(ArrayList<OrderHistory> list) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM orderHistory WHERE orderHistory_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (OrderHistory orderHistory : list) {
                st.setInt(1, orderHistory.getOrderHistoryId());
                result += st.executeUpdate();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(OrderHistory orderHistory) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE orderHistory SET order_id = ?, user_id = ?, status_id = ?, date_updateStatus = ?, reason = ? WHERE orderHistory_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, orderHistory.getOrder().getOrderId());
            st.setInt(2, orderHistory.getUser().getUserId());
            st.setInt(3, orderHistory.getStatusOrder().getStatusId());
            st.setTimestamp(4, Timestamp.valueOf(orderHistory.getTime()));
            st.setInt(5, orderHistory.getOrderHistoryId());
            st.setString(6, orderHistory.getReason());
            result = st.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
