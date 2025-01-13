import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Date;

public class ConnectionMonitor {
    public static void main(String[] args) {
        String host = "8.8.8.8"; // Google's public DNS server
        int port = 53; // DNS port
        int timeout = 1000; // 1 second timeout

        while (true) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(host, port));
                socket.setSoTimeout(timeout);
                socket.getInputStream().read(); // This will block until data is available or timeout is reached
            } catch (SocketTimeoutException e) {
                System.out.println("Connection lost at " + new Date());
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }

            try {
                Thread.sleep(1000); // Wait 1 second before checking again
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}