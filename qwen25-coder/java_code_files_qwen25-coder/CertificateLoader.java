import java.lang.String;
// Example of loading a certificate from a file in Java
import java.io.FileInputStream;
import java.security.KeyStore;

public class CertificateLoader {
    public static void main(String[] args) throws Exception {
        String certPath = "/path/to/certificate.p12";
        char[] passphrase = "your-passphrase".toCharArray();

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream fis = new FileInputStream(certPath);
        keyStore.load(fis, passphrase);

        System.out.println("Certificate loaded successfully from: " + certPath);
    }
}