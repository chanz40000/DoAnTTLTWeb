package controller.admin;

import database.ImportDAO;
import database.ImportDetailDAO;
import database.ProductDAO;
import model.Import;
import model.ImportDetail;
import model.Product;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ImportOrder", value = "/ImportOrder")
public class ImportOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("start");
        String[] productIds = request.getParameterValues("productId");
        String[] productNames = request.getParameterValues("product_name");
        String[] quantities = request.getParameterValues("numberOfWarehouses");
        String[] unitPrices = request.getParameterValues("unitPrice");
        int length = productIds.length;
        
        List<ImportDetail>importDetails = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();

        User user = (User) request.getSession().getAttribute("userC");
        Import importClass= new Import(0, user, "ncc1", "khong co gi",
                new Date(2024, 01, 12) );
        for (int i=0; i<length; i++){
            int id = Integer.parseInt(productIds[i]);
            int quantity = Integer.parseInt(quantities[i]);
            double unitPrice = Double.parseDouble(unitPrices[i]);
            double totalPrice = quantity*unitPrice;
            ImportDetail item = new ImportDetail(0, importClass,
                    productDAO.selectById(id),quantity , unitPrice, totalPrice);
            System.out.println(item.toString());
            importDetails.add(item);

            ImportDetailDAO importDetailDAO = new ImportDetailDAO();
            importDetailDAO.insert(item);

        }
        importClass.setImportDetailList(importDetails);
        ImportDAO importDAO = new ImportDAO();
        importDAO.insert(importClass);
        request.getRequestDispatcher("/WEB-INF/admin/jsp/warehouse.jsp").forward(request,response);
    }
}