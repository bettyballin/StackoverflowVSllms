import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class Main_404 {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        // Load the keystore with multiple certificates
        // You need to call keyStore.load() method here to load the keystore
        keyStore.load(null, null); // or keyStore.load(new FileInputStream("path/to/keystore.jks"), "password".toCharArray());

        String alias = "user1"; // Choose the alias for the desired certificate
        CustomKeyManager keyManager = new CustomKeyManager(keyStore, alias);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(new KeyManager[]{keyManager}, null, null);

        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        // Use the socket factory to establish connections
    }
}

// Define CustomKeyManager class
class CustomKeyManager implements KeyManager {
    private KeyStore keyStore;
    private String alias;

    public CustomKeyManager(KeyStore keyStore, String alias) {
        this.keyStore = keyStore;
        this.alias = alias;
    }

    @Override
    public String[] getClientAliases(String keyType, Principal[] issuers) {
        return new String[]{alias};
    }

    @Override
    public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
        return alias;
    }

    @Override
    public String[] getServerAliases(String keyType, Principal[] issuers) {
        return new String[]{alias};
    }

    @Override
    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        return alias;
    }

    @Override
    public X509Certificate[] getCertificateChain(String alias) {
        try {
            return (X509Certificate[]) keyStore.getCertificateChain(alias);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PrivateKey getPrivateKey(String alias) {
        try {
            return (PrivateKey) keyStore.getKey(alias, null);
        } catch (Exception e) {
            return null;
        }
    }
}