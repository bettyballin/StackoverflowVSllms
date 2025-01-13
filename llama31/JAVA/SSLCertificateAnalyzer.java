import java.lang.String;
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;

public class SSLCertificateAnalyzer {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://my.funny.url/");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.connect();

        X509Certificate[] certs = (X509Certificate[]) connection.getServerCertificates();
        X509Certificate cert = certs[0];

        System.out.println("Fingerprint: " + getFingerprint(cert));
    }

    public static String getFingerprint(X509Certificate cert) {
        return cert.getSerialNumber().toString(16);
    }
}