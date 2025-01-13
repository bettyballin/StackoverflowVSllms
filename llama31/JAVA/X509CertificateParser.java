import java.lang.String;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateFactory;
import java.io.FileInputStream;

public class X509CertificateParser {
    public static void main(String[] args) throws Exception {
        // Load the certificate from a DER file
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        X509Certificate certificate = (X509Certificate) factory.generateCertificate(new FileInputStream("path/to/certificate.der"));

        // Extract information from the certificate
        System.out.println("Subject: " + certificate.getSubjectDN());
        System.out.println("Issuer: " + certificate.getIssuerDN());
        System.out.println("Serial Number: " + certificate.getSerialNumber());
        System.out.println("Not Before: " + certificate.getNotBefore());
        System.out.println("Not After: " + certificate.getNotAfter());
    }
}