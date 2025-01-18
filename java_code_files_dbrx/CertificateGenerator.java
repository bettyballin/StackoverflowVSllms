import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.io.FileOutputStream;
import java.security.cert.X509Certificate;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;

// Base64 encoder from Bouncy Castle
import org.bouncycastle.util.encoders.Base64;

public class CertificateGenerator {
    public static void main(String[] args) throws Exception {
        // Generate the key pair ------------------
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048); // Set Key size (default is 1024)
        KeyPair kp = kpg.genKeyPair();

        // Create Certificate --------------------
        X500Name defaultNameDN = new X500Name("CN=Default");
        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(kp.getPrivate());
        X509v3CertificateBuilder certGenerator = new JcaX509v3CertificateBuilder(
            defaultNameDN,
            new BigInteger(64, new SecureRandom()),
            Calendar.getInstance().getTime(),
            new Date(Calendar.getInstance().getTime().getTime() + 1_296_000_000L),
            defaultNameDN,
            kp.getPublic()
        );
        X509Certificate signedCert = new JcaX509CertificateConverter().getCertificate(certGenerator.build(signer));
        signedCert.checkValidity(); // Confirm that the certificate is valid
        signedCert.verify(kp.getPublic());  // Confirm the key pair corresponds to this certificate

        // Export Certificate---------------------
        FileOutputStream fos = new FileOutputStream("certificate.crt");
        fos.write(Base64.encode(signedCert.getEncoded()));
        fos.close();
    }
}