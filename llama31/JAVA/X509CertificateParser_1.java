import java.lang.String;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;

import java.io.FileReader;
import java.security.Security;
import java.security.cert.X509Certificate;

public class X509CertificateParser_1_1 {
    public static void main(String[] args) throws Exception {
        // Add Bouncy Castle provider
        Security.addProvider(new BouncyCastleProvider());

        // Load the certificate from a PEM file
        PEMParser parser = new PEMParser(new FileReader("path/to/certificate.pem"));
        X509CertificateHolder holder = (X509CertificateHolder) parser.readObject();

        // Convert the certificate holder to an X509Certificate object
        JcaX509CertificateConverter converter = new JcaX509CertificateConverter();
        X509Certificate certificate = converter.getCertificate(holder);

        // Extract information from the certificate
        X500Name subject = holder.getSubject();
        System.out.println("Subject: " + subject);
        System.out.println("Issuer: " + holder.getIssuer());
        System.out.println("Serial Number: " + holder.getSerialNumber());
        System.out.println("Not Before: " + certificate.getNotBefore());
        System.out.println("Not After: " + certificate.getNotAfter());
    }
}