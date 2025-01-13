import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Main_239 {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        // Create an SSLContext
        SSLContext sslContext = SSLContext.getDefault();

        // Create an SSLServerSocketFactory
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

        try {
            // Create an SSLServerSocket
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(443);
        } catch (Exception e) {
            System.out.println("Error creating SSLServerSocket: " + e.getMessage());
        }
    }
}