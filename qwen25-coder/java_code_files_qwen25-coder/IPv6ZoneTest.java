import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;

public class IPv6ZoneTest {
    public static void main(String[] args) {
        try {
            List<NetworkInterface> interfaces =
                Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface iface : interfaces) {
                if (iface.isUp() && !iface.isLoopback()) {
                    System.out.println("Trying to connect via interface: " + iface.getName());
                    // Here you would attempt the connection using the address specific to this interface
                    // Example: tcp://[fe80::225:4bff:fea8:e201%INTERFACE_NAME]:12345
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}