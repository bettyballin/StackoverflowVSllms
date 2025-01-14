import java.lang.String;
import java.net.Socket;
import java.io.IOException;

public class SocketPortRangeExample {
    public static void main(String[] args) {
        int startPort = 5000; // Start of the port range
        int endPort = 6000;   // End of the port range

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                // Try to bind to each port in the range
                socket.bind(new java.net.InetSocketAddress(port));
                System.out.println("Successfully bound to port: " + port);
                break; // If binding is successful, exit the loop
            } catch (IOException e) {
                // Binding failed, try next port
            }
        }
    }
}