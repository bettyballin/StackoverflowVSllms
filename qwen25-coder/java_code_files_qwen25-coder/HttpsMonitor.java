import java.lang.String;
import javax.net.ssl.*;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class HttpsMonitor {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        trustAllCertificates();

        try {
            URL u = new URL("https://example.com"); // Replace with your URL
            String protocol = u.getProtocol();
            if (protocol.equals("https")) {
                HttpsURLConnection hc = (HttpsURLConnection) u.openConnection();
                System.out.println("Response Code: " + hc.getResponseCode());
                hc.disconnect();
            }
            if (protocol.equals("http")) {
                u.openConnection();
                u.getContent();
            }
            System.out.println("URL is up.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void trustAllCertificates() throws NoSuchAlgorithmException, KeyManagementException {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = (hostname, session) -> true;

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }
}