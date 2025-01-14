import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.HttpsURLConnection;
import java.security.SecureRandom;

public class TlsConnectionSetup {
    // Example of setting up a secure SSL connection in Java with TLS 1.3 preference
    static {
        System.setProperty("https.protocols", "TLSv1.3");
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
        sslContext.init(null, null, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }

    public static void main(String[] args) {
    }
}