import java.lang.String;

public class SSLConfigurator {
    static {
        System.setProperty("javax.net.ssl.trustStore", "/path/to/yourTruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "yourPassword");
    }

    public static void main(String[] args) {
    }
}