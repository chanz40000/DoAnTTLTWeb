package controller.admin;

import database.CategoryDAO;
import database.ProductDAO;
import model.Category;
import model.Product;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateProduct2", value = "/CreateProduct2")
public class CreateProduct2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý yêu cầu GET nếu cần
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Bắt đầu xử lý yêu cầu");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String productName = null;
        String categoryName = null;
        String author = null;
        String publicationYear = null;
        String description = null;
        String publisher = null;
        String uploadedFileName = null;
        String price = null;
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        // Xử lý các trường form
                        switch (item.getFieldName()) {
                            case "product_name":
                                productName = item.getString("UTF-8");
                                break;
                            case "category":
                                categoryName = item.getString("UTF-8");
                                break;
                            case "author":
                                author = item.getString("UTF-8");
                                break;
                            case "publicationYear":
                                publicationYear = item.getString("UTF-8");
                                break;
                            case "description":
                                description = item.getString("UTF-8");
                                break;
                            case "publisher":
                                publisher = item.getString("UTF-8");
                                break;
                            case "price":
                                price = item.getString("UTF-8");
                                break;
                        }
                    } else {
                        // Xử lý file upload
                        String fileName = item.getName();
                        File uploadedFile = new File(repository, fileName);
                        item.write(uploadedFile);
                        Thumbnails.of(uploadedFile).size(500, 1000)
                                .outputQuality(0.75)
                                .toFile(new File(repository, "thumb_" + fileName));
                        File imgDir = new File(servletContext.getRealPath("/image"));
                        if (uploadedFile.exists()) {
                            // Xóa tập tin đích nếu tồn tại
                            File existingFile = new File(imgDir, fileName);
                            if (existingFile.exists()) {
                                existingFile.delete();
                            }
                        }
                        if (!imgDir.exists()) {
                            imgDir.mkdir();
                        }
                        File newFile = new File(imgDir, fileName);
                        FileUtils.moveFile(uploadedFile, newFile);
                        uploadedFileName = fileName;
                    }
                }

                // Kiểm tra các giá trị cần thiết
                if (productName != null && categoryName != null && author != null && publicationYear != null &&
                        description != null && publisher != null && uploadedFileName != null) {

                    Category category = new CategoryDAO().selectByName(categoryName);

                    ProductDAO productDAO = new ProductDAO(request);
                    Product product = new Product(productDAO.creatId() + 1, productName, description,
                            uploadedFileName, 0, Double.parseDouble(price), 0, author, Integer.parseInt(publicationYear), publisher, category);

                    productDAO.insert(product);
                    System.out.println("Hoàn thành");
                } else {
                    throw new ServletException("Thiếu thông tin sản phẩm");
                }
            } catch (Exception e) {
                throw new ServletException("Không thể tải lên", e);
            }
        }

        request.getRequestDispatcher("/WEB-INF/admin/jsp/listProduct.jsp").forward(request, response);
    }
}
