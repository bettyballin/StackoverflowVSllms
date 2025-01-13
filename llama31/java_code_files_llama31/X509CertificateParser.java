/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class X509CertificateParser {
    public static void main(String[] stringArray) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate x509Certificate = (X509Certificate)certificateFactory.generateCertificate(new FileInputStream("path/to/certificate.der"));
        System.out.println("Subject: " + String.valueOf(x509Certificate.getSubjectDN()));
        System.out.println("Issuer: " + String.valueOf(x509Certificate.getIssuerDN()));
        System.out.println("Serial Number: " + String.valueOf(x509Certificate.getSerialNumber()));
        System.out.println("Not Before: " + String.valueOf(x509Certificate.getNotBefore()));
        System.out.println("Not After: " + String.valueOf(x509Certificate.getNotAfter()));
    }
}
