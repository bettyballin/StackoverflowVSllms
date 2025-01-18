import java.lang.String;
import java.net.*;
import javax.net.SocketFactory;

public class SmtpValidator {
    public static boolean isValidSmtpServer(String host, int port) {
        try (Socket socket = SocketFactory.getDefault().createSocket()) {
            socket.connect(new InetSocketAddress(host, port), 500); // Timeout - 500ms in this case
            return true;
        } catch (IOException ex) {
           // Handle exception / print stack trace here as needed
           return false;
        }
    }

    public static void main(String[] args) {
    }
}