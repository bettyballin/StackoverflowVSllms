import java.lang.String;
import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class ParseX509 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("path/to/certificate.crt")) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(fis);

            // Extracting information
            System.out.println("Subject DN: " + cert.getSubjectDN());
            System.out.println("Issuer DN: " + cert.getIssuerDN());
            System.out.println("Serial Number: " + cert.getSerialNumber());
            System.out.println("Not Before: " + cert.getNotBefore());
            System.out.println("Not After: " + cert.getNotAfter());
            System.out.println("Sig Alg Name: " + cert.getSigAlgName());

        } catch (Exception e) {
            System.err.println("Failed to parse the X.509 certificate: " + e.getMessage());
            e.printStackTrace();
        }
    }
}