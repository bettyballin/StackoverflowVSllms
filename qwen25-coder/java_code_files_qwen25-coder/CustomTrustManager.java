import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import java.security.KeyStore;
import java.security.SecureRandom;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.net.URL;

/**
 * Create a trust manager that does not validate certificate chains
 */
class CustomTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[]{};
    }

    public static SSLSocketFactory getSocketFactory(InputStream keyStoreInputStream, char[] password) {
        try {
            KeyStore trustStore = KeyStore.getInstance("PKCS12");
            trustStore.load(keyStoreInputStream, password);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), new SecureRandom());

            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static HttpsURLConnection getHttpsUrlConnection(String urlString, InputStream certInput, char[] password) throws Exception {
        URL url = new URL(urlString);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        SSLSocketFactory sslSocketFactory = getSocketFactory(certInput, password);
        urlConnection.setSSLSocketFactory(sslSocketFactory);

        // Create all-trusting host name verifier
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        urlConnection.setHostnameVerifier(hostnameVerifier);
        
        return urlConnection;
    }
}

// Usage example:
public class Main {
    public static void main(String[] args) {
        postDataUsingHttps();
    }

    public static void postDataUsingHttps() {
        try (InputStream certInput = new FileInputStream("path/to/server_certificate.p12")) { // Load your certificate here
            HttpsURLConnection connection = CustomTrustManager.getHttpsUrlConnection(
                "https://yourserver.com/end-point",
                certInput,
                "yourKeystorePassword".toCharArray()
            );
            
            // Setup your POST request and get response here...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}