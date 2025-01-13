import java.lang.String;
import javax.net.ssl.*;
import java.security.*;

public class CustomKeyManager implements X509KeyManager {
    private final KeyStore keyStore;
    private final String alias;

    public CustomKeyManager(KeyStore keyStore, String alias) {
        this.keyStore = keyStore;
        this.alias = alias;
    }

    @Override
    public String chooseClientAlias(String[] keyTypes, Principal[] issuers, Socket socket) {
        return alias;
    }

    @Override
    public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
        // Not needed for client certificates
        return null;
    }

    @Override
    public X509Certificate[] getCertificateChain(String alias) {
        try {
            return (X509Certificate[]) keyStore.getCertificateChain(alias);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PrivateKey getPrivateKey(String alias) {
        try {
            return (PrivateKey) keyStore.getKey(alias, null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}