import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.net.Socket;

public class Main_375 {
    public static void main(String[] args) throws Exception {
        // Load the truststore containing the SSL certificate
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(new FileInputStream("path/to/truststore"), "password".toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);

        // Create an SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        // Create an SSL socket factory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Establish the SSL connection
        Socket sslSocket = sslSocketFactory.createSocket("www.myserver.com", 443);

        // Use the sslSocket for communication...
        sslSocket.close(); // Close the socket to avoid resource leak
    }
}