package controller.admin;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.ReadExcelFile;

import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "upload", value = "/upload")
public class Upload extends HttpServlet {
    File file = null;
    int maxFileSize=1024*1024;
    int mawBuffSize = 1024*1024;
    String fileStorePath = "C:\\Users\\ADMIN\\Downloads";
    String tempPath = "C:\\Users\\ADMIN\\Downloads\\temp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        //write a logic for upload file
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(mawBuffSize);
        diskFileItemFactory.setRepository(new File(tempPath));
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        upload.setSizeMax(maxFileSize);
        try {
           List fileItem= upload.parseRequest(request);
           Iterator iterato = fileItem.iterator();

           while (iterato.hasNext()){
               FileItem file_item = (FileItem) iterato.next();
               if(!file_item.isFormField()){
                   String filename =file_item.getName();
                   file = new File(fileStorePath+"\\"+filename);
                   file_item.write(file);
               }
           }
            ReadExcelFile readExcelFile = new ReadExcelFile();
            JsonArray jsonArray = readExcelFile.readExcel(file.getAbsolutePath());

            out.print(jsonArray);

        }catch (FileUploadException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}