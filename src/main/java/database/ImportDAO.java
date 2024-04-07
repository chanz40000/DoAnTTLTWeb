package database;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ImportDAO extends AbsDAO<Import> {

    ArrayList<Import> imports = new ArrayList<>();
    public int creatId() {
        imports = selectAll();
        return imports.size()+1;
    }
    @Override
    public ArrayList<Import> selectAll() {
        try {
            // tao mot connection
            Connection con = JDBCUtil.getConnection();

            // tao cau lenh sql
            String sql = "SELECT * FROM imports";

            PreparedStatement st = con.prepareStatement(sql);

            // thuc thi

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int idImport = rs.getInt("import_id");
                int userId = rs.getInt("user_id");
                UserDAO userDAO = new UserDAO();
                User importer = userDAO.selectById(userId);
                String supplier = rs.getString("supplier");
                String note = rs.getString("note");
                Date dateI = rs.getDate("import_date");
                Import im = new Import(idImport,importer,supplier,note,dateI);


                imports.add(im);

            }

            JDBCUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return imports;
    }

    @Override
    public Import selectById(int id) {
        Import result = null;

        try {

            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM imports WHERE import_id =?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int idImport = rs.getInt("import_id");
                int userId = rs.getInt("user_id");
                UserDAO userDAO = new UserDAO();
                User importer = userDAO.selectById(userId);
                String supplier = rs.getString("supplier");
                String note = rs.getString("note");
                Date dateI = rs.getDate("import_date");

                result = new Import(idImport,importer, supplier,note,dateI);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int insert(Import imported) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "INSERT INTO imports(import_id, user_id, supplier,note,import_date)"
                    + "VALUE(?,?, ?, ?, ?)";

            PreparedStatement rs = con.prepareStatement(sql);

            rs.setInt(1, imported.getImportId());
            rs.setInt(2, imported.getImporter().getUserId());
            rs.setString(3, imported.getSupplier());
            rs.setString(4, imported.getNote());
            rs.setDate(5,  imported.getImportDate());


            result = rs.executeUpdate();
            System.out.println("insert successfull");
            JDBCUtil.closeConnection(con);
            this.setValue(this.gson.toJson(imported));
            int x = super.insert(imported);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int insertAll(ArrayList<Import> list) {
        int result = 0;
        for (Import im : list) {

            ;
            if (this.insert(im) == 1)
                result += 1;
        }
        return result;
    }

    @Override
    public int delete(Import imported) {
        int result = 0;

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE from imports " + "WHERE import_id=?";

            PreparedStatement rs = con.prepareStatement(sql);
            rs.setInt(1, imported.getImportId());

            result = rs.executeUpdate();

            this.setValue(this.gson.toJson(imported));
            int x = super.delete(imported);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int deleteAll(ArrayList<Import> list) {
        int result = 0;

        for (Import im : list) {
            result += delete(im);
        }
        return result;
    }

    @Override
    public int update(Import imported) {
        int result = 0;
        Import oldRating = this.selectById(imported.getImportId());

        if (oldRating != null) {

            try {
                Connection con = JDBCUtil.getConnection();

                String sql = "UPDATE imports SET user_id=?"+", supplier=? " +
                        ", note=? " +

                        ", import_date=? " +
                        "WHERE import_id = ?";

                PreparedStatement rs = con.prepareStatement(sql);

                rs.setInt(1, imported.getImporter().getUserId());
                rs.setInt(2, imported.getImportId());
                rs.setString(3, imported.getSupplier());
                rs.setString(4, imported.getNote());
                rs.setDate(5, (Date) imported.getImportDate());



                result = rs.executeUpdate();

                this.setPreValue(this.gson.toJson(oldRating));
                this.setValue(this.gson.toJson(imported));
                int x = super.update(imported);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ImportDAO importDAO = new ImportDAO();
       Import importedItem = importDAO.selectById(Integer.parseInt("1"));
       System.out.println(importedItem.toString());

       List<ImportDetail> importDetails =  importedItem.getImportDetailList();
       for(ImportDetail i: importDetails){
           System.out.println(i.getProduct().getProduct_name());
       }
    }
}
