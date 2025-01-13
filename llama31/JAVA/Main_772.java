import java.security.KeyStore;

public class Main_772 {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, "password".toCharArray());
    }
}