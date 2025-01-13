/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Main_224 {
    public static void main(String[] stringArray) {
        try {
            URL uRL = new URL("https://example.com");
            String string = uRL.getProtocol();
            if (string.equals("https")) {
                TrustManager[] trustManagerArray = new TrustManager[]{new X509TrustManager(){

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) {
                    }
                }};
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, trustManagerArray, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
                System.out.println("Response Code: " + httpsURLConnection.getResponseCode());
                httpsURLConnection.disconnect();
            }
            if (string.equals("http")) {
                uRL.openConnection();
                uRL.getContent();
            }
            System.out.println("url is up.");
        }
        catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
