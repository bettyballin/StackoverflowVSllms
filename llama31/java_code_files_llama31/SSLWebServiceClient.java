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

public class SSLWebServiceClient {
    public static void main(String[] stringArray) throws Exception {
        TrustManager[] trustManagerArray = new TrustManager[]{new X509TrustManager(){

            @Override
            public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArray, new SecureRandom());
        URL uRL = new URL("https://example.com/webservice");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        httpsURLConnection.connect();
        System.out.println("Connected to the web service.");
    }
}
