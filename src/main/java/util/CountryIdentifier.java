package util;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CountryIdentifier {

    private DatabaseReader dbReader;
    String mmdbFilepath = "C:/Users/ADMIN/eclipse-workspace/BookWeb-master/src/main/java/util/GeoLite2-Country (1).mmdb";

    public CountryIdentifier() throws IOException {
        // Khởi tạo DatabaseReader từ đường dẫn đến file GeoIP2 database

        File database = new File(mmdbFilepath);
        this.dbReader = new DatabaseReader.Builder(database).build();
    }

    public String getCountryId(HttpServletRequest request) throws IOException, GeoIp2Exception {
        // Lấy địa chỉ IP của client từ request
        String clientIpAddress = getClientIpAddress(request);
        System.out.println("clientIpAddress: "+ clientIpAddress);
        String ipv4 = IPv4Converter.convertIPv4(clientIpAddress);

            // Chuyển đổi địa chỉ IP từ dạng string sang đối tượng InetAddress
            InetAddress ip = InetAddress.getByName(ipv4);

            // Truy vấn thông tin địa lý của địa chỉ IP
            CountryResponse responsee = dbReader.country(ip);

            // In thông tin về quốc gia
            System.out.println("Country Name: " + responsee.getCountry().getName());
            System.out.println("Country ISO Code: " + responsee.getCountry().getIsoCode());
            return responsee.getCountry().getName();

    }
    public String getCountryId(String request) throws IOException, GeoIp2Exception {
        // Lấy địa chỉ IP của client từ request
        String ipv4 = IPv4Converter.convertIPv4(request);

        // Chuyển đổi địa chỉ IP từ dạng string sang đối tượng InetAddress
        InetAddress ip = InetAddress.getByName(ipv4);

        // Truy vấn thông tin địa lý của địa chỉ IP
        CountryResponse responsee = dbReader.country(ip);

        // In thông tin về quốc gia
        System.out.println("Country Name: " + responsee.getCountry().getName());
        System.out.println("Country ISO Code: " + responsee.getCountry().getIsoCode());
        return responsee.getCountry().getName();

    }

    public String getClientIpAddress(HttpServletRequest request) {
        // Lấy địa chỉ IP của client từ HTTP request
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

       return ipAddress;

    }


    public static void main(String[] args) {

        String mmdbFilepath = "C:/Users/ADMIN/eclipse-workspace/BookWeb-master/src/main/java/util/GeoLite2-Country (1).mmdb";

        String ipv6Address = "0:0:0:0:0:0:0:1";
        try {
            new CountryIdentifier().getCountryId(ipv6Address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (GeoIp2Exception e) {
            throw new RuntimeException(e);
        }


           }

    }


