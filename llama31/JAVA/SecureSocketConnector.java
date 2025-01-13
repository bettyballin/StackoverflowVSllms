import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.UnknownHostException;

public class SecureSocketConnector {
    public static void main(String[] args) {
        try {
            SSLContext sslContext = SSLContext.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocketFactory().createSocket("example.com", 443);
            // ... exchange private information ...
            SSLSession session = sslSocket.getSession();
            session.invalidate();
            sslSocket.startHandshake();
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}