package util;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;

import java.io.File;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPv4Converter {

    public static String IPv6ToIPv4(String ipAddress) {
        try {
            InetAddress inet6Address = InetAddress.getByName(ipAddress);
            if (inet6Address instanceof Inet6Address) {
                Inet6Address inet6 = (Inet6Address) inet6Address;
                byte[] ipv4Bytes = new byte[4];
                System.arraycopy(inet6.getAddress(), 12, ipv4Bytes, 0, 4);
                InetAddress inet4Address = InetAddress.getByAddress(ipv4Bytes);
                System.out.println("IPv4 Address: " + inet4Address.getHostAddress());
                return inet4Address.getHostAddress();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String convertIPv4(String ipAddress) {
        ipAddress = IPv6ToIPv4(ipAddress);
        String[] octets = ipAddress.split("\\.");

        if (octets.length != 4) {
            throw new IllegalArgumentException("Invalid IPv4 address format");
        }

        // Parse octets
        int octet1 = Integer.parseInt(octets[0]);
        int octet2 = Integer.parseInt(octets[1]);
        int octet3 = Integer.parseInt(octets[2]);
        int octet4 = Integer.parseInt(octets[3]);

        // Perform bitwise operations to transform the IP address
        int convertedOctet1 = octet1 | 0b10000000; // Set the first bit to 1
        int convertedOctet2 = octet2;
        int convertedOctet3 = octet3;
        int convertedOctet4 = octet4;

        // Construct the converted IP address string
        String convertedIpAddress = String.format("%d.%d.%d.%d",
                convertedOctet1, convertedOctet2,
                convertedOctet3, convertedOctet4);

        return convertedIpAddress;
    }
    public static void main(String[] args) {
        String ipAddress = "0.0.0.1";
        String convertedIpAddress = convertIPv4(ipAddress);
        System.out.println("Converted IP Address: " + convertedIpAddress);
    }


}
