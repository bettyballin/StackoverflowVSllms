import java.net.Socket;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.io.IOException;

public class SocketHandler {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("example.com", 80);
            // Perform I/O operations using the socket.
        } catch (ConnectException e) {
            System.err.println("Connection refused. The host is likely unreachable.");
        } catch (SocketTimeoutException e) {
            System.err.println("Connection timed out. The host may not be reachable or is unresponsive.");
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        } finally {
            // Attempt to close the socket.
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing the socket: " + e.getMessage());
            }
        }
    }
}