import java.lang.String;
public class KeyStoreConfigurator {
    static String keyStorePassword = System.getenv("KEYSTORE_PASSWORD");
    static {
        System.setProperty("javax.net.keyStorePassword", keyStorePassword);
    }

    public static void main(String[] args) {
    }
}