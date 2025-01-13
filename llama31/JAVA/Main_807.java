import java.lang.String;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main_807 {
    public static void main(String[] args) {
        String input = "example.com"; // or "192.168.1.1"
        try {
            InetAddress address = InetAddress.getByName(input);
            if (address.getHostAddress().equals(input)) {
                System.out.println("It's an IP address");
            } else {
                System.out.println("It's a hostname");
            }
        } catch (UnknownHostException e) {
            System.out.println("Invalid input");
        }
    }
}