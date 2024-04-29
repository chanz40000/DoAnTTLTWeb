package Test;

import database.JDBCUtil;
import database.PaymentDAO;
import database.UserDAO;
import model.Order;
import model.Payment;
import model.User;
import util.PasswordEncryption;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM customer";

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idcustomer");
                String username = rs.getString("username");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String password=rs.getString("password");
                String gender=rs.getString("gender");

                Customer customer = new Customer(id, name, username, email, password, gender);
                customers.add(customer);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;

    }

    public int insert(Customer customer) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO book.customer(idcustomer, username, name, email, password, gender)"
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement rs = con.prepareStatement(sql);

            rs.setInt(1, customer.getId());
            rs.setString(2, customer.getUsername());
            rs.setString(3, customer.getName());
            rs.setString(4, customer.getEmail());
            rs.setString(5, customer.getPassword());
            rs.setString(6, customer.getGender());

            result = rs.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return result;


    }

    public int delete(int customer) {
        int result = 0;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE from customer " + "WHERE idcustomer=?";

            PreparedStatement rs = con.prepareStatement(sql);
            rs.setInt(1, customer);

            result = rs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void main(String[] args) {
        new CustomerDAO().delete(5);
        System.out.println("done");
    }

}
