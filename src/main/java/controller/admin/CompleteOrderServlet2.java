package controller.admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import database.ImportDAO;
import database.ImportDetailDAO;
import database.ProductDAO;
import model.Import;
import model.ImportDetail;
import model.User;

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

        //them vao database
        ImportDAO importDAO = new ImportDAO(request);
        ImportDetailDAO importDetailDAO = new ImportDetailDAO();
        ProductDAO productDAO = new ProductDAO(request);

        User user = (User) request.getSession().getAttribute("admin");
        System.out.println("id: "+ user.getUserId());

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        int import_id = importDAO.creatId();

        String notes = items.get(0).note;

        Import importClass= new Import(import_id, user, "ncc1", notes, date );
        importDAO.insert(importClass);


        System.out.println("action");
        double total = 0;
        for (Item item : items) {
            int idProduct = Integer.parseInt(item.getProductId()) ;
            String nameProduct = item.productName;
            int quantity = item.getNumberOfWarehouses();

            double unitPrice = item.unitPrice;


            double totalPrice = quantity*unitPrice;
            System.out.println("name"+nameProduct);
            System.out.println("quantity"+quantity);
            total+=totalPrice;
            System.out.println("total: "+total);
            model.ImportDetail itemm = new ImportDetail(importDetailDAO.creatId(), importClass,
                    productDAO.selectById(idProduct),quantity , unitPrice, quantity*unitPrice);

            importDetailDAO.insert(itemm);

            productDAO.updateQuantityIncrease(idProduct, quantity);

        }
        //set lai tong tien
        importClass.setTotalPrice(total);
        importDAO.update(importClass);
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