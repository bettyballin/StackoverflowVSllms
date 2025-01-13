import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.NoSuchAlgorithmException;

public class SSLContextInitializer {
    public static void main(String[] args) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, null);
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        SSLContext.setDefault(sslContext);
    }
}