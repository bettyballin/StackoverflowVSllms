/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Main_693 {
    public static void main(String[] stringArray) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate x509Certificate = (X509Certificate)certificateFactory.generateCertificate(new FileInputStream("root-ca.crt"));
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
        keyStore.setCertificateEntry("root-ca", x509Certificate);
        keyStore.store(new FileOutputStream("truststore.jks"), "changeit".toCharArray());
    }
}
