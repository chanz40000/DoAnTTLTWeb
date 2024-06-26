package controller.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CompleteOrderServlet2", value = "/CompleteOrderServlet2")
public class CompleteOrderServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("done do post");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Đọc dữ liệu JSON từ request body
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        String jsonData = jsonBuilder.toString();

        // Sử dụng Gson để chuyển đổi JSON thành danh sách các đối tượng Item
        Gson gson = new Gson();
        List<Item> items = gson.fromJson(jsonData, new TypeToken<List<Item>>(){}.getType());

        System.out.println("item"+ items.get(1).note+items.get(1).productName);
        // Xử lý dữ liệu (ví dụ: lưu vào cơ sở dữ liệu)
        // ...

        // Gửi phản hồi về cho client
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
       System.out.print("{\"message\": \"Nhập hàng thành công!\"}");
        out.flush();
    }

    // Lớp Item đại diện cho mỗi mục trong danh sách
    class Item {
        private String productId;
        private String productName;
        private int numberOfWarehouses;
        private double unitPrice;
        private double totalPrice;
        private String note;

        // Các getter và setter
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getNumberOfWarehouses() {
            return numberOfWarehouses;
        }

        public void setNumberOfWarehouses(int numberOfWarehouses) {
            this.numberOfWarehouses = numberOfWarehouses;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }
    }
}