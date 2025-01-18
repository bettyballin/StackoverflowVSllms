import java.io.*;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class Main {
    public static void main(String[] args) throws Exception {
        KeyStore ks = KeyStore.getInstance("JKS"); // Default java keystore type is JKS (Java Keystore)
        // But you can use other types supported by Oracle based on your requirement (BKS, PKCS12, etc.)

        char[] password = null; // Password for the keystore

        InputStream ksin = new FileInputStream("path to java cacerts file");
        // cacerts is the default truststore present in JAVA_HOME/lib/security directory.
        // Please replace it with your path as per your environment if you are using different truststores.

        try { ks.load(ksin, password); } finally { ksin.close(); }

        Certificate cert = null; // Define your certificate here

        ks.setCertificateEntry("alias", cert);  // Store the certificate

        OutputStream out = new FileOutputStream("path to your keystore file"); // If you have a file in place, replace with its path.
        try { ks.store(out, password); } finally { out.close(); }
    }
}