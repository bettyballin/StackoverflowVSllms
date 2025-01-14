import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class ParseX509WithBouncyCastle {
    public static void main(String[] args) {
        try {
            // Add Bouncy Castle Provider
            Security.addProvider(new BouncyCastleProvider());

            try (FileInputStream fis = new FileInputStream("path/to/certificate.crt")) {
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                X509Certificate x509Cert = (X509Certificate) cf.generateCertificate(fis);

                // Using Bouncy Castle to hold and parse
                X509CertificateHolder certificateHolder = new X509CertificateHolder(x509Cert.getEncoded());
                JcaX509CertificateConverter converter = new JcaX509CertificateConverter();
                X509Certificate bcCert = converter.getCertificate(certificateHolder);

                // Extracting information
                System.out.println("Subject DN: " + bcCert.getSubjectDN());
                System.out.println("Issuer DN: " + bcCert.getIssuerDN());
            }
        } catch (Exception e) {
            System.err.println("Failed to parse the X.509 certificate with Bouncy Castle: " + e.getMessage());
            e.printStackTrace();
        }
    }
}