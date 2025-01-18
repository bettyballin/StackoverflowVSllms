import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLContext;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

// Implement your class
public class MySSLSocketFactory {

    // Implement HostnameVerifier for your SSLSocketFactory creation
    private static final TrustManager[] trustAllCerts = new TrustManager[] {
        new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() { 
                return new X509Certificate[0]; 
            }
            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) { }
            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) { }
        }
    };

    // Create an SSLContext that uses our TrustManager
    private static SSLContext ssl_ctx = null;

    static {
        try {
            ssl_ctx = SSLContext.getInstance("TLS"); // use TLS as security protocol
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (ssl_ctx != null) {
            try {
                SSLSecurity.enableDebugging();
                ssl_ctx.init(null, trustAllCerts, new SecureRandom());
                // Pass the context to your SSLSocketFactory
                HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// Dummy SSLSecurity class to prevent compilation errors
class SSLSecurity {
    public static void enableDebugging() {
        // Implement debugging logic if necessary
    }
}