import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

public class KeystoreLoader {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream inputStream = new FileInputStream("keystore.jks");
        char[] password = "mysecretpassword".toCharArray();
        keyStore.load(inputStream, password);
    }
}