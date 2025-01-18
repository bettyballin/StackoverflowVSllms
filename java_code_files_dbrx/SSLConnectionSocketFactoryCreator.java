import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

public class SSLConnectionSocketFactoryCreator {

    public static void main(String[] args) throws Exception {
        // Setup SSLContext
        SSLContext sc = SSLContexts.custom().setProtocol("TLS").build(); // or other setup of SSLContext

        // Declare KeyManager array (assuming kms1 is of type KeyManager[])
        KeyManager[] kms1 = null; // Replace null with actual KeyManager array if available

        // Create SSLConnectionSocketFactory instances
        SSLConnectionSocketFactory sslSocketFactory1 = new SSLConnectionSocketFactory(
                sc, 
                "TLSv1.2", 
                null, 
                null, 
                kms1
        );
        SSLConnectionSocketFactory sslSocketFactory2 = new SSLConnectionSocketFactory(
                sc, 
                "TLSv1.2", 
                null, 
                null, 
                kms1
        );
    }
}