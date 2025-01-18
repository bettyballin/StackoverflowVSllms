import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;

public class KeystoreLoader {

    public static void main(String[] args) {
        try (final FileInputStream fis = new FileInputStream("keystore.jks")) { // replace with your keystore file location and name including extension
            KeyStore keyStore = KeyStore.getInstance("JKS"); // type of the keystore, here JKS is used
            String password = "your-password"; // replace with your own
            BufferedReader readPasswordline = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Keystore Password:");
            keyStore.load(fis, password.toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
            // Handle exception according to your implementation requirements
            e.printStackTrace();
        }
    }

}