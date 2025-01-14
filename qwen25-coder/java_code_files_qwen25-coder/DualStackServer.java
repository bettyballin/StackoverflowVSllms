import java.lang.String;
import java.net.ServerSocket;
import java.net.Socket;

public class DualStackServer {
    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Listening on port 8080 for both IPv4 and IPv6...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connected client: " + socket.getInetAddress());
                // Process the connection
            }
        }
    }
}