import java.lang.String;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateLoader {
    String filename = "test.cer";   // Name of your certificate file (.pem/.crt)
    X509Certificate cert;

    public CertificateLoader() {
        try {
            InputStream fin = new FileInputStream(filename);
            CertificateFactory f = CertificateFactory.getInstance("X.509");
            cert = (X509Certificate) f.generateCertificate(fin); // Generate certificate from the .cer file
        } catch (IOException | CertificateException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}