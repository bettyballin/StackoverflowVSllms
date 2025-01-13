import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Main_693 {
    public static void main(String[] args) throws Exception {
        // Load the root CA certificate
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate rootCaCert = (X509Certificate) cf.generateCertificate(new FileInputStream("root-ca.crt"));

        // Create a truststore
        KeyStore truststore = KeyStore.getInstance("JKS");
        truststore.load(null, null); // Initialize an empty truststore
        truststore.setCertificateEntry("root-ca", rootCaCert);

        // Save the truststore
        truststore.store(new FileOutputStream("truststore.jks"), "changeit".toCharArray());
    }
}