package controller.admin;

import database.ImportDAO;
import database.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteImport", value = "/DeleteImport")
public class DeleteImport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("id"+id);
        ImportDAO importDAO = new ImportDAO();
        importDAO.delete(importDAO.selectById(Integer.parseInt(id)));
        request.getRequestDispatcher("/WEB-INF/admin/jsp/listImport.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}