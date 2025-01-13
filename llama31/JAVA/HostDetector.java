import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostDetector {
    public static void main(String[] args) {
        String ipRange = "192.168.1."; // replace with your LAN's IP range
        for (int i = 1; i <= 254; i++) {
            String ipAddress = ipRange + i;
            try {
                InetAddress address = InetAddress.getByName(ipAddress);
                if (address.isReachable(1000)) { // 1000ms timeout
                    System.out.println(ipAddress + " is reachable");
                }
            } catch (UnknownHostException e) {
                // ignore
            } catch (IOException e) {
                // handle exception
            }
        }
    }
}