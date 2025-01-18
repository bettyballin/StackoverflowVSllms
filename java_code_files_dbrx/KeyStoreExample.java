import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

public class KeyStoreExample {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS"); // use "PKCS12" if you want to use PKCS#12 store
        InputStream keyStoreFileStream = new FileInputStream(new File("keystore"));
        // the password that you used when generating your keystore file,
        // must be kept secret in secure storage and never leak into the source code or version control systems.
        keyStore.load(keyStoreFileStream, "<your-password>".toCharArray());
    }
}