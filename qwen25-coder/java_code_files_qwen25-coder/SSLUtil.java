import java.lang.String;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class SSLUtil {

    public SSLSocketFactory getTrustAllSSLSocketFactory() throws Exception {
        TrustAllX509TrustManager trustManager = new TrustAllX509TrustManager();
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new javax.net.ssl.TrustManager[] { trustManager }, null);
        return sslContext.getSocketFactory();
    }

    public static void main(String[] args) {
    }

    public static class TrustAllX509TrustManager implements X509TrustManager {
        public void checkClientTrusted( X509Certificate[] certs, String authType ) {
        }

        public void checkServerTrusted( X509Certificate[] certs, String authType ) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}