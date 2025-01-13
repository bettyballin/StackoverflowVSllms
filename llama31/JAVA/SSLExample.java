import java.lang.String;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLExample {
    public static void main(String[] args) throws Exception {
        // Create an SSL context
        SSLContext sslContext = SSLContext.getDefault();

        // Create an SSLSocketFactory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Create an SSLSocket
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("example.com", 443);

        // Establish an SSL connection
        sslSocket.startHandshake();

        // Use the SSL connection
        // ...

        // Close the SSL connection
        sslSocket.close();
    }
}