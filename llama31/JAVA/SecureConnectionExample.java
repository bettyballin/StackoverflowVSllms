import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SecureConnectionExample {
    public static void main(String[] args) {
        try {
            // Create an SSL context
            SSLContext sslContext = SSLContext.getDefault();

            // Create an SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Create an SSL socket
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(InetAddress.getByName("example.com"), 443);

            // Enable all supported cipher suites
            String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
            sslSocket.setEnabledCipherSuites(supportedCipherSuites);

            // Start the SSL handshake
            sslSocket.startHandshake();

            // Use the SSL socket for secure communication
            // ...

            // Close the SSL socket
            sslSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}