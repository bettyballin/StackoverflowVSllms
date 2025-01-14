import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class SecureConnectionExample {
    public static void main(String[] args) {
        try {
            // Set up the SSL context to allow for old versions (not recommended for production)
            SSLContext sslc = SSLContext.getInstance("SSLv3"); // Avoid using "SSLv3" in production
            sslc.init(null, null, new java.security.SecureRandom());
            
            // Create an SSL socket factory with our SSL context
            SSLSocketFactory ssf = (SSLSocketFactory)sslc.getSocketFactory();
            
            // Open a secure socket to the destination host and port
            SSLSocket sock = (SSLSocket)ssf.createSocket("example.com", 443);
            
            System.out.println("Securely connected to " + sock.getInetAddress());
            sock.close(); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}