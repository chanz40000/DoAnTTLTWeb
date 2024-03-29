package controller.admin;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import database.ImportDAO;
import database.ImportDetailDAO;
import database.ProductDAO;
import model.Import;
import model.ImportDetail;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "CompleteOrderServlet", value = "/CompleteOrderServlet")
public class CompleteOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Không cần thực hiện gì trong phương thức doGet
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("done do post");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            System.out.println(line+"  : line");
        }
        reader.close();

        String data = URLDecoder.decode(sb.toString(), "UTF-8");
        data = data.substring(1, data.length()-2);
        String[] importDetails = data.split(","); // Sử dụng split("/") để tách chuỗi thành mảng dữ liệu

        //them vao database
        ImportDAO importDAO = new ImportDAO();
        ImportDetailDAO importDetailDAO = new ImportDetailDAO();
        ProductDAO productDAO = new ProductDAO();

        User user = (User) request.getSession().getAttribute("userC");

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        Import importClass= new Import(importDAO.creatId(), user, "ncc1", "khong co gi", date );

        importDAO.insert(importClass);
        for (String part : importDetails) {
            String decodedPart = URLDecoder.decode(part, "UTF-8");

            System.out.println(decodedPart);
            String[]dataDetail = decodedPart.split("-");

                int idProduct = Integer.parseInt(dataDetail[0]);
                String nameProduct = dataDetail[1];
                int quantity = Integer.parseInt(dataDetail[2]);
//                if(dataDetail[3].endsWith("."))dataDetail[3]+="0";

                double unitPrice = Double.parseDouble(dataDetail[3]);

            ImportDetail item = new ImportDetail(importDetailDAO.creatId(), importClass,
                    productDAO.selectById(idProduct),quantity , unitPrice, quantity*unitPrice);

            importDetailDAO.insert(item);
            productDAO.updateQuantityIncrease(idProduct, quantity);
            importClass.getImportDetailList().add(item);
        }
        // Lưu trữ và xử lý dữ liệu ở đây
        response.getWriter().write("Data received successfully");
    }

}
