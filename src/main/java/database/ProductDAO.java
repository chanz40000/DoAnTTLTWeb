//<<<<<<< HEAD
//package database;
//
//import model.Category;
//import model.Product;
//
//import javax.servlet.http.HttpServletRequest;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ProductDAO extends AbsDAO<Product> {
//
//    public ProductDAO(HttpServletRequest request) {
//        super(request);
//    }
//
//    public ProductDAO() {
//    }
//
//    private ArrayList<Product> data = new ArrayList<>();
//
//    public int creatId() {
//        data = selectAll();
//        return data.size();
//    }
//
//    @Override
//    public ArrayList<Product> selectAll() {
//        ArrayList<Product> products = new ArrayList<>();
//        try {
//            // tao mot connection
//            Connection con = JDBCUtil.getConnection();
//
//            // tao cau lenh sql
//            String sql = "SELECT * FROM products";
//
//            PreparedStatement st = con.prepareStatement(sql);
//
//            // thuc thi
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId);
//                Product product = new Product(idProduct, nameProduct, description, image, unitPrice, price, quantity, author, publicationYear, publisher, category);
//
//
//                products.add(product);
//
//            }
//
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return products;
//    }
//
//    public ArrayList<Product> selectAllOrderBy() {
//        ArrayList<Product> products = new ArrayList<>();
//        try {
//            // tao mot connection
//            Connection con = JDBCUtil.getConnection();
//
//            // tao cau lenh sql
//            String sql = "SELECT * FROM products";
//
//            PreparedStatement st = con.prepareStatement(sql);
//
//            // thuc thi
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId);
//                Product product = new Product(idProduct, nameProduct, description, image, unitPrice, price, quantity, author, publicationYear, publisher, category);
//
//
//                products.add(product);
//
//            }
//
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return products;
//    }
//
//    public ArrayList<Product> selectAllOrderBytt(String orderBy) {
//        ArrayList<Product> products = new ArrayList<>();
//        try {
//            // tao mot connection
//            Connection con = JDBCUtil.getConnection();
//
//            // tao cau lenh sql
//            String sql = "SELECT * FROM products";
//            if ("price-asc".equals(orderBy)) {
//                sql += " ORDER BY price";
//            } else if ("price-desc".equals(orderBy)) {
//                sql += " ORDER BY price DESC";
//            } else {
//                // mặc định sắp xếp theo ID sản phẩm
//                sql += " ORDER BY CAST(product_id AS SIGNED)";
//            }
//            PreparedStatement st = con.prepareStatement(sql);
//
//            // thuc thi
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId);
//                Product product = new Product(idProduct, nameProduct, description, image, unitPrice, price, quantity, author, publicationYear, publisher, category);
//
//
//                products.add(product);
//
//            }
//
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return products;
//    }
//
//    //dem trang
//    public List<Product> getListByPage(List<Product> list, int start, int end) {
//        List<Product> arr = new ArrayList<Product>();
//        for (int i = start; i < end; i++) {
//            arr.add(list.get(i));
//        }
//        return arr;
//    }
//
//    @Override
//    public Product selectById(int id) {
//        Product result = null;
//
//        try {
//
//            Connection con = JDBCUtil.getConnection();
//
//            String sql = "SELECT * FROM products WHERE product_id =?";
//
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId);
//                result = new Product(idProduct, nameProduct, description, image, unitPrice, price, quantity, author, publicationYear, publisher, category);
//
//            }
//
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    @Override
//    public int insert(Product product) {
//        int result = 0;
//        this.setValue(this.gson.toJson(product));
//        try {
//            Connection con = JDBCUtil.getConnection();
//
//            String sql = "INSERT INTO products(product_id, product_name, description, image, unit_price, price, quantity, author,publication_year,publisher,category_id)"
//                    + "VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//            PreparedStatement rs = con.prepareStatement(sql);
//
//            rs.setInt(1, product.getProductId());
//            rs.setString(2, product.getProduct_name());
//            rs.setString(3, product.getDescription());
//            rs.setString(4, product.getImage());
//            rs.setDouble(5, product.getUnitPrice());
//            rs.setDouble(6, product.getPrice());
//            rs.setInt(7, product.getQuantity());
//            rs.setString(8, product.getAuthor());
//            rs.setInt(9, product.getPublicationYear());
//            rs.setString(10, product.getPublisher());
//            rs.setInt(11, product.getCategory().getCategoryId());
//
//            result = rs.executeUpdate();
//            super.insert(product);
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return result;
//    }
//
//    @Override
//    public int insertAll(ArrayList<Product> list) {
//        int result = 0;
//        for (Product product : list) {
//
//            ;
//            if (this.insert(product) == 1)
//                result += 1;
//        }
//        return result;
//    }
//
//    @Override
//    public int delete(Product product) {
//        int result = 0;
//        this.setValue(this.gson.toJson(product));
//        try {
//            Connection con = JDBCUtil.getConnection();
//
//            String sql = "DELETE from products " + "WHERE product_id=?";
//
//            PreparedStatement rs = con.prepareStatement(sql);
//            rs.setInt(1, product.getProductId());
//
//            result = rs.executeUpdate();
//            super.delete(product);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return result;
//    }
//
//    @Override
//    public int deleteAll(ArrayList<Product> list) {
//        int result = 0;
//
//        for (Product product : list) {
//            result += delete(product);
//        }
//        return result;
//    }
//
//    @Override
//    public int update(Product product) {
//        int result = 0;
//        Product oldProduct = this.selectById(product.getProductId());
//        this.setValue(this.gson.toJson(product));
//        this.setPreValue(this.gson.toJson(oldProduct));
//        if (oldProduct != null) {
//
//            try {
//                Connection con = JDBCUtil.getConnection();
//
//
//                String sql = "UPDATE book.products SET  product_name=? " +
//                        ", description=? " +
//                        ", image=? " +
//                        ", unit_price=? " +
//                        ", price=? " +
//                        ", quantity=?" +
//                        ", author=?" +
//                        ", publication_year=? " +
//                        ", publisher=? " +
//                        ", category_id=? " +
//                        "WHERE product_id =?";
//
//                PreparedStatement rs = con.prepareStatement(sql);
//
//                rs.setString(1, product.getProduct_name());
//                rs.setString(2, product.getDescription());
//                rs.setString(3, product.getImage());
//                rs.setDouble(4, product.getUnitPrice());
//                rs.setDouble(5, product.getPrice());
//                rs.setInt(6, product.getQuantity());
//                rs.setString(7, product.getAuthor());
//                rs.setInt(8, product.getPublicationYear());
//                rs.setString(9, product.getPublisher());
//                rs.setInt(10, product.getCategory().getCategoryId());
//                rs.setInt(11, product.getProductId());
//
//
//                result = rs.executeUpdate();
//                super.update(product);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        return result;
//    }
//
//    public int updateQuantityIncrease(int idProduct, int quantity) {
//        int result = 0;
//        Product oldProduct = this.selectById(idProduct);
//        this.setPreValue(this.gson.toJson(oldProduct));
//        oldProduct.setQuantity(oldProduct.getQuantity() + quantity);
//        this.setValue(this.gson.toJson(oldProduct));
//
//
//        int quantityUpdate = oldProduct.getQuantity() + quantity;
//        try {
//            Connection con = JDBCUtil.getConnection();
//
//            String sql = "UPDATE book.products SET quantity = ? " +
//                    "WHERE product_id = ?";
//
//            PreparedStatement rs = con.prepareStatement(sql);
//            rs.setInt(1, quantityUpdate);
//            rs.setInt(2, idProduct);
//            result = rs.executeUpdate();
//            super.update(oldProduct);
//            System.out.println("Cap nhat thanh cong");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//
//        return result;
//    }
//
//    public ArrayList<Product> selectByProductName(String productName) {
//
//        ArrayList<Product> products = new ArrayList<>();
//        try {
//            // tao mot connection
//            Connection con = JDBCUtil.getConnection();
//
//            // tao cau lenh sql
//            String sql = "SELECT * FROM products WHERE product_name LIKE ? ";
//
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setString(1, "%" + productName + "%");
//            // thuc thi
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId);
//                Product product = new Product(idProduct, nameProduct, description, image, unitPrice, price, quantity, author, publicationYear, publisher, category);
//
//
//                products.add(product);
//
//            }
//
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return products;
//    }
//    public ArrayList<Product> selectByCategoryName(String categoryName) {
//
//        ArrayList<model.Product> products = new ArrayList<>();
//        try {
//            // Create a connection
//            Connection con = JDBCUtil.getConnection();
//
//            // Prepare the SQL query with a placeholder for category name
//            String sql = "SELECT * FROM products " +
//                    "JOIN categories ON products.category_id = categories.category_id " +
//                    "WHERE category_name LIKE ?";
//
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setString(1, "%"+ categoryName +"%");
//
//
//            // Execute the query and process results
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId); // Assuming CategoryDAO has selectById method
//                model.Product product = new model.Product(idProduct, nameProduct, description, image, unitPrice, price, quantity, author, publicationYear, publisher, category);
//
//                products.add(product);
//            }
//
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return products;
//    }
//    public ArrayList<Product> selectPrice(int low, int high) {
//        ArrayList<Product> products = new ArrayList<>();
//        try {
//            // tao mot connection
//            Connection con = JDBCUtil.getConnection();
//
//            // tao cau lenh sql
//            String sql = "SELECT * FROM products where price >= " + low + " and price <= " + high;
//
//            PreparedStatement st = con.prepareStatement(sql);
//
//            // thuc thi
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId);
//                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);
//
//
//                products.add(product);
//
//            }
//
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return products;
//    }
//    public int selectCategoryId(int productid) {
//        int categoryId = -1; // Khởi tạo categoryId mặc định là -1 (nếu không tìm thấy)
//
//        try {
//            // Tạo một kết nối
//            Connection con = JDBCUtil.getConnection();
//
//            // Tạo câu lệnh SQL
//            String sql = "SELECT category_id FROM products WHERE product_id=?";
//
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setInt(1, productid);
//            ResultSet rs = st.executeQuery();
//
//            if (rs.next()) {
//                categoryId = rs.getInt("category_id");
//            }
//
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return categoryId;
//    }
//    public ArrayList<Product> selectSameCategory(int categoryid,int productid) {
//        ArrayList<Product> products = new ArrayList<>();
//        try {
//            // tao mot connection
//            Connection con = JDBCUtil.getConnection();
//
//            // tao cau lenh sql
//            String sql = "SELECT * FROM products WHERE category_id=? AND product_id != ?";
//
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setInt(1, categoryid);
//            st.setInt(2, productid);
//
//            // thuc thi
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId);
//                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);
//
//
//                products.add(product);
//
//            }
//
//            JDBCUtil.closeConnection(con);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return products;
//    }
//
//
//
//    public int inventoryProduct(int idProduct) {
//        //sl ton kho
//        int result = 0;
//        //tong sl nhap
//        int totalWarehouse = 0;
//
//        int totalExported = 0;
//        //tinh tong san pham nhap
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "SELECT SUM(number_of_warehouses) AS tong_nhap FROM importdetails WHERE product_id=?";
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setInt(1, idProduct);
//            ResultSet res = pre.executeQuery();
//            while (res.next()) {
//                totalWarehouse = res.getInt("tong_nhap");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        //tinh tong sl ban
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "SELECT SUM(quantity) AS tong_xuat FROM orderdetails WHERE product_id=?";
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setInt(1, idProduct);
//            ResultSet res = pre.executeQuery();
//            while (res.next()) {
//                totalExported = res.getInt("tong_xuat");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        result = totalWarehouse - totalExported;
//        return result;
//    }
//
//    //tinh tong so san pham ton kho
//    public Map<Integer, Integer> inventoryProduct2() {
//        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "SELECT SUM(a.tong_nhap-b.tong_xuat)as tonKho, a.product_id\n" +
//                    "FROM (SELECT SUM(number_of_warehouses) AS tong_nhap, product_id  FROM importdetails GROUP BY product_id) a \n" +
//                    "     JOIN (SELECT SUM(quantity) AS tong_xuat,product_id  FROM orderdetails GROUP BY product_id) b\n" +
//                    "     ON a.product_id = b.product_id\n" +
//                    "     GROUP BY a.product_id ";
//            PreparedStatement pre = con.prepareStatement(sql);
//            ResultSet res = pre.executeQuery();
//            while (res.next()) {
//                int quantity = res.getInt("tonKho");
//                int product_id = res.getInt("product_id");
//                result.put(quantity, product_id);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    //lay danh sach san pham khong ban duoc trong 3 thang gan day ma truoc do da tung ban
//    public ArrayList<Product> productCannotBeSold() {
//        ArrayList<Product> result = new ArrayList<>();
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "SELECT *\n" +
//                    "FROM products\n" +
//                    "WHERE product_id NOT IN (\n" +
//                    "    SELECT a.product_id\n" +
//                    "    FROM orderdetails a\n" +
//                    "    JOIN orders b ON a.order_id = b.order_id\n" +
//                    "    WHERE b.booking_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)\n" +
//                    ")\n" +
//                    "AND product_id  IN (\n" +
//                    "    SELECT a.product_id\n" +
//                    "    FROM orderdetails a\n" +
//                    "    JOIN orders b ON a.order_id = b.order_id\n" +
//                    "    WHERE b.booking_date < DATE_SUB(NOW(), INTERVAL 3 MONTH)\n" +
//                    ");";
//            PreparedStatement pre = con.prepareStatement(sql);
//            ResultSet rs = pre.executeQuery();
//            while (rs.next()) {
//                int idProduct = rs.getInt("product_id");
//                String nameProduct = rs.getString("product_name");
//                String description = rs.getString("description");
//                String image = rs.getString("image");
//                double unitPrice = rs.getDouble("unit_price");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                String author = rs.getString("author");
//                int publicationYear = rs.getInt("publication_year");
//                String publisher = rs.getString("publisher");
//                int categoryId = rs.getInt("category_id");
//
//                Category category = new CategoryDAO().selectById(categoryId);
//                Product product = new Product(idProduct, nameProduct, description, image, unitPrice, price, quantity, author, publicationYear, publisher, category);
//
//
//                result.add(product);
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
////san pham can nhap hang
////SELECT product_id, SUM(quantity_sold) AS quantity_sold, SUM(quantity_imported) AS quantity_imported
////    FROM (
////            SELECT p.product_id,
////            IFNULL(SUM(od.quantity), 0) AS quantity_sold,
////           0 AS quantity_imported
////    FROM products p
////    LEFT JOIN orderdetails od ON p.product_id = od.product_id
////    LEFT JOIN orders o ON od.order_id = o.order_id
////    WHERE o.booking_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)
////    GROUP BY p.product_id
////
////    UNION ALL
////
////    SELECT product_id,
////           0 AS quantity_sold,
////    IFNULL(SUM(number_of_warehouses), 0) AS quantity_imported
////    FROM importdetails a
////    LEFT JOIN imports b ON a.import_id = b.import_id
////    WHERE b.import_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)
////    GROUP BY product_id
////) AS combined
////    GROUP BY product_id
////    HAVING (SUM(quantity_sold) - SUM(quantity_imported)) > 0;
//
//    public ArrayList<Integer> needImport() {
//        ArrayList<Integer> result = new ArrayList<>();
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "SELECT product_id, SUM(quantity_sold) AS quantity_sold, SUM(quantity_imported) AS quantity_imported\n" +
//                    "FROM (\n" +
//                    "    SELECT p.product_id, \n" +
//                    "           IFNULL(SUM(od.quantity), 0) AS quantity_sold,\n" +
//                    "           0 AS quantity_imported\n" +
//                    "    FROM products p\n" +
//                    "    LEFT JOIN orderdetails od ON p.product_id = od.product_id\n" +
//                    "    LEFT JOIN orders o ON od.order_id = o.order_id\n" +
//                    "    WHERE o.booking_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)\n" +
//                    "    GROUP BY p.product_id\n" +
//                    "    \n" +
//                    "    UNION ALL\n" +
//                    "    \n" +
//                    "    SELECT product_id, \n" +
//                    "           0 AS quantity_sold,\n" +
//                    "           IFNULL(SUM(number_of_warehouses), 0) AS quantity_imported\n" +
//                    "    FROM importdetails a\n" +
//                    "    LEFT JOIN imports b ON a.import_id = b.import_id\n" +
//                    "    WHERE b.import_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)\n" +
//                    "    GROUP BY product_id\n" +
//                    ") AS combined\n" +
//                    "GROUP BY product_id\n" +
//                    "HAVING (SUM(quantity_sold) - SUM(quantity_imported)) > 0;";
//            PreparedStatement pre = con.prepareStatement(sql);
//            ResultSet rs = pre.executeQuery();
//            while (rs.next()) {
//                int idProduct = rs.getInt("product_id");
//
//
//                result.add(idProduct);
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//}

package database;

import model.Category;
import model.Product;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO extends AbsDAO<Product> {

    public ProductDAO(HttpServletRequest request) {
        super(request);
    }

    public ProductDAO(){
    }
    private ArrayList<Product> data = new ArrayList<>();
    public int creatId() {
        data = selectAll();
        return data.size();
    }
    @Override
    public ArrayList<Product> selectAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products";

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public ArrayList<Product> selectAllOrderBy() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products";

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public ArrayList<Product> selectByCategoryName(String categoryName) {

        ArrayList<model.Product> products = new ArrayList<>();
        try {
            // Create a connection
            Connection con = JDBCUtil.getConnection();

            // Prepare the SQL query with a placeholder for category name
            String sql = "SELECT * FROM products " +
                    "JOIN categories ON products.category_id = categories.category_id " +
                    "WHERE category_name LIKE ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+ categoryName +"%");


            // Execute the query and process results
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId); // Assuming CategoryDAO has selectById method
                model.Product product = new model.Product(idProduct, nameProduct, description, image, unitPrice, price, quantity, author, publicationYear, publisher, category);

                products.add(product);
            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public ArrayList<Product> selectPrice(int low, int high) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products where price >= " + low + " and price <= " + high;

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public ArrayList<Product> selectAllOrderBytt(String orderBy) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products";
            if ("price-asc".equals(orderBy)) {
                sql += " ORDER BY price";
            } else if ("price-desc".equals(orderBy)) {
                sql += " ORDER BY price DESC";
            } else {
                // mặc định sắp xếp theo ID sản phẩm
                sql += " ORDER BY CAST(product_id AS SIGNED)";
            }
            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public int selectCategoryId(int productid) {
        int categoryId = -1; // Khởi tạo categoryId mặc định là -1 (nếu không tìm thấy)

        try {
            // Tạo một kết nối
            Connection con = JDBCUtil.getConnection();

            // Tạo câu lệnh SQL
            String sql = "SELECT category_id FROM products WHERE product_id=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, productid);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                categoryId = rs.getInt("category_id");
            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categoryId;
    }
    public ArrayList<Product> selectSameCategory(int categoryid,int productid) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products WHERE category_id=? AND product_id != ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, categoryid);
            st.setInt(2, productid);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    //dem trang
    public List<Product> getListByPage(List<Product> list, int start, int end){
        List<Product> arr = new ArrayList<Product>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }
    @Override
    public Product selectById(int id) {
        Product result = null;

        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM products WHERE product_id =?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                result = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);

            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int insert(Product product) {
        int result = 0;
        this.setValue(this.gson.toJson(product));
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO products(product_id, product_name, description, image, unit_price, price, quantity, author,publication_year,publisher,category_id)"
                    + "VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement rs = con.prepareStatement(sql);

            rs.setInt(1, product.getProductId());
            rs.setString(2, product.getProduct_name());
            rs.setString(3, product.getDescription());
            rs.setString(4, product.getImage());
            rs.setDouble(5, product.getUnitPrice());
            rs.setDouble(6, product.getPrice());
            rs.setInt(7, product.getQuantity());
            rs.setString(8, product.getAuthor());
            rs.setInt(9, product.getPublicationYear());
            rs.setString(10, product.getPublisher());
            rs.setInt(11, product.getCategory().getCategoryId());

            result = rs.executeUpdate();
            super.insert(product);
            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int insertAll(ArrayList<Product> list) {
        int result = 0;
        for (Product product : list) {

            ;
            if (this.insert(product) == 1)
                result += 1;
        }
        return result;
    }

    @Override
    public int delete(Product product) {
        int result = 0;
        this.setValue(this.gson.toJson(product));
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE from products " + "WHERE product_id=?";

            PreparedStatement rs = con.prepareStatement(sql);
            rs.setInt(1, product.getProductId());

            result = rs.executeUpdate();
            super.delete(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int deleteAll(ArrayList<Product> list) {
        int result = 0;

        for (Product product : list) {
            result += delete(product);
        }
        return result;
    }
    public int updateQuantityOrder(int productId, int newQuantity) {
        int result = 0;
        Product oldProduct = this.selectById(productId);

        if (oldProduct != null) {
            try (Connection connection = JDBCUtil.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET quantity = ? WHERE product_id = ?")) {
                preparedStatement.setInt(1, newQuantity);
                preparedStatement.setInt(2, productId);
                result = preparedStatement.executeUpdate();
                System.out.println("Cập nhật số lượng thành công");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    @Override
    public int update(Product product) {
        int result = 0;
        Product oldProduct = this.selectById(product.getProductId());
        this.setValue(this.gson.toJson(product));
        this.setPreValue(this.gson.toJson(oldProduct));
        if (oldProduct != null) {

            try {
                Connection con = JDBCUtil.getConnection();


                String sql = "UPDATE book.products SET  product_name=? " +
                        ", description=? " +
                        ", image=? " +
                        ", unit_price=? " +
                        ", price=? " +
                        ", quantity=?"+
                        ", author=?"+
                        ", publication_year=? " +
                        ", publisher=? " +
                        ", category_id=? " +
                        "WHERE product_id =?";

                PreparedStatement rs = con.prepareStatement(sql);

                rs.setString(1, product.getProduct_name());
                rs.setString(2, product.getDescription());
                rs.setString(3, product.getImage());
                rs.setDouble(4, product.getUnitPrice());
                rs.setDouble(5, product.getPrice());
                rs.setInt(6, product.getQuantity());
                rs.setString(7, product.getAuthor());
                rs.setInt(8, product.getPublicationYear());
                rs.setString(9, product.getPublisher());
                rs.setInt(10, product.getCategory().getCategoryId());
                rs.setInt(11, product.getProductId());


                result = rs.executeUpdate();
                super.update(product);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    public int updateQuantityIncrease(int idProduct, int quantity) {
        int result = 0;
        Product oldProduct = this.selectById(idProduct);
        this.setPreValue(this.gson.toJson(oldProduct));
        oldProduct.setQuantity(oldProduct.getQuantity()+quantity);
        this.setValue(this.gson.toJson(oldProduct));


        int quantityUpdate = oldProduct.getQuantity()+quantity;
            try {
                Connection con = JDBCUtil.getConnection();

                String sql = "UPDATE book.products SET quantity = ? " +
                        "WHERE product_id = ?";

                PreparedStatement rs = con.prepareStatement(sql);
                rs.setInt(1, quantityUpdate);
                rs.setInt(2, idProduct);
                result = rs.executeUpdate();
                super.update(oldProduct);
                System.out.println("Cap nhat thanh cong");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        return result;
    }

    public ArrayList<Product> selectByProductName(String productName) {

        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products WHERE product_name LIKE ? ";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+ productName +"%");
            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public int inventoryProduct(int idProduct){
        //sl ton kho
        int result =0;
        //tong sl nhap
        int totalWarehouse=0;

        int totalExported=0;
        //tinh tong san pham nhap
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT SUM(number_of_warehouses) AS tong_nhap FROM importdetails WHERE product_id=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, idProduct);
            ResultSet res = pre.executeQuery();
            while (res.next()){
                totalWarehouse = res.getInt("tong_nhap");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //tinh tong sl ban
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT SUM(quantity) AS tong_xuat FROM orderdetails WHERE product_id=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, idProduct);
            ResultSet res = pre.executeQuery();
            while (res.next()){
                totalExported = res.getInt("tong_xuat");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        result = totalWarehouse-totalExported;
        return result;
    }
//tinh tong so san pham ton kho
    public Map<Integer, Integer> inventoryProduct2(){
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT SUM(a.tong_nhap-b.tong_xuat)as tonKho, a.product_id\n" +
                    "FROM (SELECT SUM(number_of_warehouses) AS tong_nhap, product_id  FROM importdetails GROUP BY product_id) a \n" +
                    "     JOIN (SELECT SUM(quantity) AS tong_xuat,product_id  FROM orderdetails GROUP BY product_id) b\n" +
                    "     ON a.product_id = b.product_id\n" +
                    "     GROUP BY a.product_id ";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            while (res.next()){
                int quantity = res.getInt("tonKho");
                int product_id = res.getInt("product_id");
                result.put(product_id, quantity);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
//lay danh sach san pham khong ban duoc trong 3 thang gan day ma truoc do da tung ban
public ArrayList<Product> productCannotBeSold(){
    ArrayList<Product> result = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql ="SELECT * FROM products \n" +
                " WHERE product_id NOT IN ( \n" +
                "  SELECT a.product_id \n" +
                " FROM orderdetails a \n" +
                " JOIN orders b ON a.order_id = b.order_id \n" +
                " WHERE b.booking_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH) \n" +
                " AND product_id  IN (  SELECT a.product_id \n" +
                " FROM orderdetails a   JOIN orders b ON a.order_id = b.order_id \n" +
                "WHERE b.booking_date < DATE_SUB(NOW(), INTERVAL 3 MONTH)));";
        PreparedStatement pre = con.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()){
            int idProduct = rs.getInt("product_id");
            String nameProduct = rs.getString("product_name");
            String description = rs.getString("description");
            String image = rs.getString("image");
            double unitPrice = rs.getDouble("unit_price");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            String author = rs.getString("author");
            int publicationYear = rs.getInt("publication_year");
            String publisher = rs.getString("publisher");
            int categoryId = rs.getInt("category_id");

            Category category = new CategoryDAO().selectById(categoryId);
            Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


            result.add(product);

        }
    }catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return result;
}
    public ArrayList<Product> selectByCategoryName(String categoryname) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products WHERE category LIKE ? ";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%"+ categoryname +"%");
            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public ArrayList<Product> selectPrice(int low, int high) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products where price >= " + low + " and price <= " + high;

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public int selectCategoryId(int productid) {
        int categoryId = -1; // Khởi tạo categoryId mặc định là -1 (nếu không tìm thấy)

        try {
            // Tạo một kết nối
            Connection con = JDBCUtil.getConnection();

            // Tạo câu lệnh SQL
            String sql = "SELECT category_id FROM products WHERE product_id=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, productid);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                categoryId = rs.getInt("category_id");
            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categoryId;
    }
    public ArrayList<Product> selectSameCategory(int categoryid,int productid) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM products WHERE category_id=? AND product_id != ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, categoryid);
            st.setInt(2, productid);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idProduct = rs.getInt("product_id");
                String nameProduct = rs.getString("product_name");
                String description = rs.getString("description");
                String image = rs.getString("image");
                double unitPrice = rs.getDouble("unit_price");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String author = rs.getString("author");
                int publicationYear = rs.getInt("publication_year");
                String publisher = rs.getString("publisher");
                int categoryId = rs.getInt("category_id");

                Category category = new CategoryDAO().selectById(categoryId);
                Product product = new Product(idProduct,nameProduct,description,image,unitPrice,price,quantity,author,publicationYear,publisher,category);


                products.add(product);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
//san pham can nhap hang
//SELECT product_id, SUM(quantity_sold) AS quantity_sold, SUM(quantity_imported) AS quantity_imported
//    FROM (
//            SELECT p.product_id,
//            IFNULL(SUM(od.quantity), 0) AS quantity_sold,
//           0 AS quantity_imported
//    FROM products p
//    LEFT JOIN orderdetails od ON p.product_id = od.product_id
//    LEFT JOIN orders o ON od.order_id = o.order_id
//    WHERE o.booking_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)
//    GROUP BY p.product_id
//
//    UNION ALL
//
//    SELECT product_id,
//           0 AS quantity_sold,
//    IFNULL(SUM(number_of_warehouses), 0) AS quantity_imported
//    FROM importdetails a
//    LEFT JOIN imports b ON a.import_id = b.import_id
//    WHERE b.import_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)
//    GROUP BY product_id
//) AS combined
//    GROUP BY product_id
//    HAVING (SUM(quantity_sold) - SUM(quantity_imported)) > 0;

    public ArrayList<Integer> needImport(){
        ArrayList<Integer> result = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT product_id, SUM(quantity_sold) AS quantity_sold, SUM(quantity_imported) AS quantity_imported\n" +
                    "FROM (\n" +
                    "    SELECT p.product_id, \n" +
                    "           IFNULL(SUM(od.quantity), 0) AS quantity_sold,\n" +
                    "           0 AS quantity_imported\n" +
                    "    FROM products p\n" +
                    "    LEFT JOIN orderdetails od ON p.product_id = od.product_id\n" +
                    "    LEFT JOIN orders o ON od.order_id = o.order_id\n" +
                    "    WHERE o.booking_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)\n" +
                    "    GROUP BY p.product_id\n" +
                    "    \n" +
                    "    UNION ALL\n" +
                    "    \n" +
                    "    SELECT product_id, \n" +
                    "           0 AS quantity_sold,\n" +
                    "           IFNULL(SUM(number_of_warehouses), 0) AS quantity_imported\n" +
                    "    FROM importdetails a\n" +
                    "    LEFT JOIN imports b ON a.import_id = b.import_id\n" +
                    "    WHERE b.import_date >= DATE_SUB(NOW(), INTERVAL 3 MONTH)\n" +
                    "    GROUP BY product_id\n" +
                    ") AS combined\n" +
                    "GROUP BY product_id\n" +
                    "HAVING (SUM(quantity_sold) - SUM(quantity_imported)) > 0;";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                int idProduct = rs.getInt("product_id");


                result.add(idProduct);

            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list;
        list = new ProductDAO().needImport();
        for (Integer p:list){
            System.out.println(p);
        }
    }
}

