import java.lang.String;
import java.net.Inet4Address;
import java.net.InetAddress;

public class IPAddressChecker {
    public static void main(String[] args) {
        String input = "example.com"; // Replace with your input string

        if (isIPv4(input)) {
            System.out.println("Input is an IPv4 address.");
        } else if (isIPv6(input)) {
            System.out.println("Input is an IPv6 address.");
        } else {
            System.out.println("Input is a hostname.");
        }
    }

    public static boolean isIPv4(String input) {
        try {
            return Inet4Address.getByName(input).getHostAddress().equals(input);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isIPv6(String input) {
        try {
            InetAddress address = InetAddress.getByName(input);
            // Check if the address is an instance of Inet6Address
            // and matches the original input to ensure it's a valid IPv6 string
            return !address.isLoopbackAddress() && 
                   address.getHostAddress().equals(input) &&
                   (address instanceof java.net.Inet6Address);
        } catch (Exception e) {
            return false;
        }
    }
}