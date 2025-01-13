import java.lang.String;
import java.net.DatagramSocket;
import java.net.SocketException;

public class PortRangeSocket {
    public static void main(String[] args) {
        int minPort = 4000;
        int maxPort = 5000;

        for (int port = minPort; port <= maxPort; port++) {
            try {
                DatagramSocket socket = new DatagramSocket(port);
                System.out.println("Bound to port: " + port);
                // Use the socket...
                break;
            } catch (SocketException e) {
                System.out.println("Port " + port + " is in use.");
            }
        }
    }
}