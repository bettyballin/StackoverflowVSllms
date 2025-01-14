import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.net.URL;

public class SslTunnelIgnoreHostname {
    public static void createConnection() throws Exception {
        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Set up a TrustManager that trusts everything
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { 
                    return new X509Certificate[0]; 
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        // Now try to send an HTTPS request. The server will need a certificate.
        URL url = new URL("https://localhost:1234");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        System.out.println(conn.getResponseCode());
    }

    public static void main(String[] args) throws Exception {
        createConnection();
    }
}