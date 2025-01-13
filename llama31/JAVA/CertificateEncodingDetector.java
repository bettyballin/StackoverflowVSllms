import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateEncodingDetector {
    public static void main(String[] args) throws CertificateException {
        File certificateFile = new File("path/to/certificate");
        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        try (FileInputStream fis = new FileInputStream(certificateFile)) {
            X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);
            System.out.println("Certificate is DER encoded");
        } catch (CertificateException e) {
            try (FileInputStream fis = new FileInputStream(certificateFile)) {
                String pemContent = new String(fis.readAllBytes());
                if (pemContent.startsWith("-----BEGIN CERTIFICATE-----")) {
                    System.out.println("Certificate is Base64 encoded (PEM format)");
                } else {
                    System.out.println("Unknown encoding type");
                }
            } catch (IOException ex) {
                System.out.println("Error reading certificate file");
            }
        }
    }
}