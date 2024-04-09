package database;

import com.google.gson.Gson;
import model.Log;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.ip2location.*;
import com.ip2location.IP2Location;

public class AbsDAO <T> implements DAOInterface<T> {
//    private String nameOfTable="";
    private String preValue="";
    private String value="";
    private String ipAddress="";
    private String national = "";
    Gson gson = new Gson();

    HttpServletRequest request;



    public int getCountryCode(HttpServletRequest request) {
        try {
            // Khởi tạo đối tượng IP2Location
            IP2Location ip2Location = new IP2Location();

            // Thiết lập đường dẫn đến tệp cơ sở dữ liệu IP2Location
            String dbPath = "src/main/java/util/IP2LOCATION-LITE-DB1.BIN"; // Đường dẫn đến tệp cơ sở dữ liệu IP2Location
            ip2Location.Open(dbPath);

            // Lấy địa chỉ IP từ header X-Forwarded-For
             ipAddress = request.getHeader("X-Forwarded-For");

            // Nếu không có header X-Forwarded-For, lấy địa chỉ IP từ RemoteAddr
            if (ipAddress == null || ipAddress.isEmpty()) {
                ipAddress = request.getRemoteAddr();
            }

            // Chuyển đổi địa chỉ IP thành số nguyên
            long ipNumber = ipToLong(ipAddress);

            // Tra cứu thông tin về địa chỉ IP
            IPResult result = ip2Location.IPQuery(ipAddress);

            // Lấy mã quốc gia từ kết quả tra cứu
            String countryCode = result.getCountryShort();

            // Đóng kết nối với cơ sở dữ liệu
            ip2Location.Close();

            // Trả về mã quốc gia dưới dạng số nguyên
            return countryCode.hashCode(); // or any other appropriate method to convert string to integer

        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Return -1 or any other default value to indicate failure
        }
    }

    // Chuyển đổi địa chỉ IP từ dạng String thành số nguyên
    public static long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }
    public AbsDAO(HttpServletRequest request) {
        this.request=request;
        System.out.println(request.getLocalPort());
    }

    public AbsDAO() {
    }

//    public String getNameOfTable() {
//        return nameOfTable;
//    }
//
//    public void setNameOfTable(String nameOfTable) {
//        this.nameOfTable = nameOfTable;
//    }

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    @Override
    public ArrayList<T> selectAll() {

        return null;
    }

    @Override
    public T selectById(int id) {
        return null;
    }

    @Override
    public int insert(T t) {
        LogDAO logDAO = new LogDAO();
        Log log = new Log(logDAO.creatId(), "INFO",LocalDateTime.now(), this.getIpAddress(), null, value, 84);
        new LogDAO().update(log);
        return 0;
    }

    @Override
    public int insertAll(ArrayList<T> list) {
        return 0;
    }

    @Override
    public int delete(T t) {
        LogDAO logDAO = new LogDAO();
        Log log = new Log(logDAO.creatId(), "WARNING",LocalDateTime.now(), this.getIpAddress(), null, value, 84);
        new LogDAO().update(log);
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<T> list) {
        return 0;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Gson getGson() {
        return gson;
    }

    @Override
    public int update(T t) {
        LogDAO logDAO = new LogDAO();
        Log log = new Log(logDAO.creatId(), "INFO", LocalDateTime.now() , this.getIpAddress(), preValue, value, 84);
        new LogDAO().update(log);
        return 0;
    }
}
