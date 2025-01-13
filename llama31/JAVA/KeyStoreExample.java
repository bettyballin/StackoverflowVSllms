import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.spec.SecretKeySpec;

public class KeyStoreExample {
    public static void main(String[] args) throws Exception {
        // Create a KeyStore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);

        // Generate a secret key
        Key key = new SecretKeySpec("mysecretkey".getBytes(), "AES");

        // Store the key in the KeyStore
        keyStore.setKeyEntry("mykey", key, "mypassword".toCharArray(), null);

        // Save the KeyStore to a file
        keyStore.store(new FileOutputStream("keystore.jks"), "mypassword".toCharArray());
    }
}