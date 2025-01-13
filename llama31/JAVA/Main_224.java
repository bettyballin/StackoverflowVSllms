import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URL;
import java.security.cert.X509Certificate;

public class Main_224 {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://example.com"); // Replace with your URL
            String protocol = u.getProtocol();

            if (protocol.equals("https")) {
                TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }};

                SSLContext sc = SSLContext.getInstance("TLS");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

                HttpsURLConnection hc = (HttpsURLConnection) u.openConnection();
                System.out.println("Response Code: " + hc.getResponseCode());
                hc.disconnect();
            }

            if (protocol.equals("http")) {
                u.openConnection();
                u.getContent();
            }

            System.out.println("url is up.");
        } catch (Exception e) {
            // Handle exception
            System.err.println("Error: " + e.getMessage());
        }
    }
}