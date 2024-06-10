package controller.admin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "Upload2", value = "/Upload2")
public class Upload2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Đọc dữ liệu JSON từ yêu cầu
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        System.out.println("Received JSON data: " + sb.toString());
        try {
            // Parse JSON data
            JSONObject jsonObject = new JSONObject(sb.toString());

            // Extract the "productNames" array
            JSONArray productNamesArray = jsonObject.getJSONArray("productNames");

            // Iterate through the array
            for (int i = 0; i < productNamesArray.length(); i++) {
                String productName = productNamesArray.getString(i);
                System.out.println("Product Name: " + productName);
            }

            // Send response
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Received " + productNamesArray.length() + " product names.");
        } catch (JSONException e) {
            // Handle JSON parsing error
            e.printStackTrace();
            // Send error response
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid JSON data.");
        }
//        System.out.println("daqua");
//
//        // Đọc JSON từ yêu cầu
//        StringBuilder stringBuilder = new StringBuilder();
//        String line = null;
//        try {
//            while ((line = request.getReader().readLine()) != null) {
//                stringBuilder.append(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String jsonInput = stringBuilder.toString();
//
//        JsonObject jsonObject = JsonParser.parseString(jsonInput).getAsJsonObject();
//        String filePath = jsonObject.get("filePath").toString();
//        System.out.println("daqua json"+filePath);
//        // Đảm bảo bạn đã tải lên tệp và đặt nó vào đúng vị trí
//        // Ở đây giả định rằng bạn đã tải tệp lên và biết vị trí của nó trên server
//        // Sử dụng đường dẫn file để đọc và xử lý nó
//        List<Product> productNames = new ArrayList<>();
//        ProductDAO productDAO = new ProductDAO();
//        filePath = filePath.replaceAll("\"", "");
//        System.out.println("duong dan: "+ "C:\\Users\\ADMIN\\Downloads\\"+filePath);
//        String filePathString = "C:\\Users\\ADMIN\\Downloads\\"+filePath;
//        // Check if file exists
//        if (!Files.exists(Paths.get(filePathString))) {
//            response.getWriter().write("File not found: " + filePathString);
//            return;
//        }
//
//        try (FileInputStream fis = new FileInputStream(filePathString);
//             Workbook workbook = WorkbookFactory.create(fis)) {
//
//            Sheet sheet = workbook.getSheetAt(0);
//            if (sheet!= null) {
//                response.getWriter().write("Sheet not found");
//                System.out.println("Sheet not found");
//                return;
//            }
//
//            System.out.println("Sheet found, number of rows: " + sheet.getPhysicalNumberOfRows()); // Debugging
//
//            for (Row row : sheet) {
//                System.out.println("Reading row: " + row.getRowNum()); // Debugging
//                if (row.getRowNum() == 0) continue; // Skip header row
//
//                Cell cell = row.getCell(0);
//                if (cell != null) {
//                    String productName = cell.getStringCellValue();
//                    System.out.println("Product Name: " + productName);
//                    // Add logic to process the product name
//                    // e.g., productNames.add(productName);
//                } else {
//                    System.out.println("Cell is null"); // Debugging
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            response.getWriter().write("Error reading file: " + e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().write("Unexpected error: " + e.getMessage());
//        }
//

      //  String jsonResponse = new Gson().toJson(productNames);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(jsonResponse);
    
    }
}