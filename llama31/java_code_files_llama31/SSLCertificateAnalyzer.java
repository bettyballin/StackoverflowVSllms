/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;

public class SSLCertificateAnalyzer {
    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("https://my.funny.url/");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
        httpsURLConnection.connect();
        X509Certificate[] x509CertificateArray = (X509Certificate[])httpsURLConnection.getServerCertificates();
        X509Certificate x509Certificate = x509CertificateArray[0];
        System.out.println("Fingerprint: " + SSLCertificateAnalyzer.getFingerprint(x509Certificate));
    }

    public static String getFingerprint(X509Certificate x509Certificate) {
        return x509Certificate.getSerialNumber().toString(16);
    }
}
