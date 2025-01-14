import java.lang.String;
import java.io.FileOutputStream;
import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyStoreExample {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        keyStore.load(null, "password".toCharArray());

        // Create AES Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        // Save the Key in the Keystore
        keyStore.setEntry("aes-key", new KeyStore.SecretKeyEntry(secretKey), null);

        // write to file, protecting your keystore with a password - please use better security for real applications!
        try (FileOutputStream fos = new FileOutputStream("keystore.jceks")) {
            keyStore.store(fos, "password".toCharArray());
        }
    }
}