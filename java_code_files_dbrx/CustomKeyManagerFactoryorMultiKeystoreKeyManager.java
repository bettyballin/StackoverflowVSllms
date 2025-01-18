import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManager;

public class CustomKeyManagerFactoryorMultiKeystoreKeyManager {
    public static void main(String[] args) throws Exception {
        // Get your first keystore file
        FileInputStream fis1 = new FileInputStream("path/to/your/keystore1");
        KeyStore keyStore1 = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore1.load(fis1, "password".toCharArray()); // The password must be set as char[]

        // Get your second keystore file
        FileInputStream fis2 = new FileInputStream("path/to/your/keystore2");
        KeyStore keyStore2 = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore2.load(fis2, "password".toCharArray()); // The password must be set as char[]

        // Create a KeyManager for each certificate
        KeyManagerFactory kmfactory1 = KeyManagerFactory.getInstance("SunX509");
        kmfactory1.init(keyStore1, "password".toCharArray()); // password of keystore
        KeyManagerFactory kmfactory2 = KeyManagerFactory.getInstance("SunX509");
        kmfactory2.init(keyStore2, "password".toCharArray()); // password of keystore

        // For simplicity this example only gets the first key manager for each factory
        KeyManager[] kms1 = new KeyManager[]{ kmfactory1.getKeyManagers()[0] };
        KeyManager[] kms2 = new KeyManager[]{ kmfactory2.getKeyManagers()[0] };
    }
}