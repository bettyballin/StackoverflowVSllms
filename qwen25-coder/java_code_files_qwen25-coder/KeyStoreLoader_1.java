import java.io.InputStream;
import java.security.KeyStore;

public class KeyStoreLoader_1 {

    InputStream certInputStream;
    KeyStore keyStore;
    char[] pwdArray;

    public KeyStoreLoader_1() throws Exception {
        certInputStream = getClass().getResourceAsStream("/certificate.pfx");
        keyStore = KeyStore.getInstance("PKCS12");
        pwdArray = "yourPassword".toCharArray();
        keyStore.load(certInputStream, pwdArray);
    }

    public static void main(String[] args) {
        // Optionally, create an instance to execute the code
        try {
            KeyStoreLoader_1 loader = new KeyStoreLoader_1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}