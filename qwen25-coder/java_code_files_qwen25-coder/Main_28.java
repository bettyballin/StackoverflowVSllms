import javax.net.ssl.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        MultiCertSSLSocketFactory.KeyManagerSet km1 = new MultiCertSSLSocketFactory.KeyManagerSet(
                "user1", "password".toCharArray(), "/path/to/user1.p12");
        MultiCertSSLSocketFactory.KeyManagerSet km2 = new MultiCertSSLSocketFactory.KeyManagerSet(
                "user2", "password".toCharArray(), "/path/to/user2.p12");

        // Add all key managers you need
        MultiCertSSLSocketFactory scf = new MultiCertSSLSocketFactory(km1, km2);

        // To use a specific cert based on user ID:
        String userIdToUse = "user1";
        KeyManager kmToUse = null;
        for (MultiCertSSLSocketFactory.KeyManagerSet set : Arrays.asList(km1, km2)) {
            if (set.getUserId().equals(userIdToUse)) {
                kmToUse = set.getKeyManager();
                break;
            }
        }

        if (kmToUse != null) {
            SSLContext sslContext = scf.getSSLContext(kmToUse);
            SSLSocket socket = (SSLSocket) sslContext.getSocketFactory().createSocket("localhost", 443);
            // Use the socket as needed
        } else {
            throw new Exception("No suitable certificate found");
        }
    }
}

class MultiCertSSLSocketFactory {

    private KeyManagerSet[] keyManagerSets;

    public MultiCertSSLSocketFactory(KeyManagerSet... keyManagerSets) {
        this.keyManagerSets = keyManagerSets;
    }

    public SSLContext getSSLContext(KeyManager km) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(new KeyManager[]{km}, null, new SecureRandom());
        return sslContext;
    }

    public static class KeyManagerSet {
        private String userId;
        private KeyManager keyManager;

        public KeyManagerSet(String userId, char[] password, String keyStorePath)
                throws KeyStoreException, IOException, NoSuchAlgorithmException,
                CertificateException, UnrecoverableKeyException {
            this.userId = userId;
            this.keyManager = createKeyManager(password, keyStorePath);
        }

        private KeyManager createKeyManager(char[] password, String keyStorePath)
                throws KeyStoreException, IOException, NoSuchAlgorithmException,
                CertificateException, UnrecoverableKeyException {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");

            try (FileInputStream fis = new FileInputStream(keyStorePath)) {
                keyStore.load(fis, password);
            }

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, password);
            return kmf.getKeyManagers()[0];
        }

        public String getUserId() {
            return userId;
        }

        public KeyManager getKeyManager() {
            return keyManager;
        }
    }
}