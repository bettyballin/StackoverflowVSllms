import java.lang.String;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MACAddressFetcher {
    public static void main(String[] args) {
        try {
            // Replace "192.168.1.10" with the target IP address
            InetAddress inet = InetAddress.getByName("192.168.1.10");

            NetworkInterface network = NetworkInterface.getByInetAddress(inet);
            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}