import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.cert.*;
import org.bouncycastle.cert.jcajce.*;
import org.bouncycastle.operator.*;
import org.bouncycastle.operator.jcajce.*;

public class CertificateGenerator {
    public static void main(String[] args) throws Exception {
        // Add BouncyCastle as a security provider
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
        keyGen.initialize(2048, new SecureRandom());
        KeyPair pair = keyGen.generateKeyPair();

        // Create certificate validity period
        Date start = new Date();
        Date end = new Date(System.currentTimeMillis() + (10L * 365 * 24 * 60 * 60 * 1000)); // 10 years from now

        // Define the X.509 certificate information
        X500Name owner = new X500Name("CN=Test Certificate");

        BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());

        // Create certificate builder
        JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
                owner,
                serialNumber,
                start,
                end,
                owner,
                pair.getPublic()
        );

        // Sign the certificate
        ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA").build(pair.getPrivate());

        X509CertificateHolder certHolder = certBuilder.build(signer);
        X509Certificate cert = new JcaX509CertificateConverter().setProvider("BC").getCertificate(certHolder);

        // Save the certificate as a file or use it directly
        // For example, saving to a file:
        try (FileOutputStream fos = new FileOutputStream("mycert.cer")) {
            fos.write(cert.getEncoded());
        }
    }
}