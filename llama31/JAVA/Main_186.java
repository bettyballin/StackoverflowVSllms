import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.Properties;
import javax.mail.Session;

public class Main_186 {
    public static void main(String[] args) throws Exception {
        // Create a trust manager that ignores certificate errors
        TrustManager[] trustAllCerts = new TrustManager[] {
            new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };

        // Create an SSL context that uses the trust manager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

        // Use the SSL context in your javax.mail API
        Properties props = new Properties();
        props.put("mail.smtp.ssl.socketFactory", sslContext.getSocketFactory());
        
        // Create a new Session object to use the properties
        Session session = Session.getDefaultInstance(props);
    }
}