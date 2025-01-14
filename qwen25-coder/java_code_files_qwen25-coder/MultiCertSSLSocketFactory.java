import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.CertificateException;

public class MultiCertSSLSocketFactory extends SSLSocketFactory {

    private final KeyManager[] keyManagers;
    private final TrustManager[] trustManagers;

    public MultiCertSSLSocketFactory(KeyManagerSet... keyManagerSets) throws Exception {
        KeyManager[] kms = new KeyManager[keyManagerSets.length];
        for (int i = 0; i < keyManagerSets.length; i++) {
            kms[i] = keyManagerSets[i].getKeyManager();
        }
        this.keyManagers = kms;

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore ts = KeyStore.getInstance(KeyStore.getDefaultType());
        ts.load(null);
        tmf.init(ts);
        this.trustManagers = tmf.getTrustManagers();
    }

    @Override
    public String[] getDefaultCipherSuites() {
        try {
            return getDefaultFactory().getDefaultCipherSuites();
        } catch (Exception e) {
            return new String[0];
        }
    }

    @Override
    public String[] getSupportedCipherSuites() {
        try {
            return getDefaultFactory().getSupportedCipherSuites();
        } catch (Exception e) {
            return new String[0];
        }
    }

    private SSLSocketFactory getDefaultFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, null, null);
        return ctx.getSocketFactory();
    }

    private SSLContext getSSLContext(KeyManager km) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[]{km}, trustManagers, null);
        return ctx;
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        try {
            SSLSocket sslSocket = (SSLSocket) getSSLContext(keyManagers[0]).getSocketFactory().createSocket(s, host, port, autoClose);
            return sslSocket;
        } catch (Exception e) {
            throw new IOException("Failed to create SSL socket", e);
        }
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        try {
            SSLSocket sslSocket = (SSLSocket) getSSLContext(keyManagers[0]).getSocketFactory().createSocket(host, port);
            return sslSocket;
        } catch (Exception e) {
            throw new IOException("Failed to create SSL socket", e);
        }
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        try {
            SSLSocket sslSocket = (SSLSocket) getSSLContext(keyManagers[0]).getSocketFactory().createSocket(host, port);
            return sslSocket;
        } catch (Exception e) {
            throw new IOException("Failed to create SSL socket", e);
        }
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        try {
            SSLSocket sslSocket = (SSLSocket) getSSLContext(keyManagers[0]).getSocketFactory().createSocket(host, port, localHost, localPort);
            return sslSocket;
        } catch (Exception e) {
            throw new IOException("Failed to create SSL socket", e);
        }
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        try {
            SSLSocket sslSocket = (SSLSocket) getSSLContext(keyManagers[0]).getSocketFactory().createSocket(address, port, localAddress, localPort);
            return sslSocket;
        } catch (Exception e) {
            throw new IOException("Failed to create SSL socket", e);
        }
    }

    // Example class to encapsulate a key manager and its associated criteria
    public static class KeyManagerSet {
        private final String userId; // or other selector
        private final KeyManager keyManager;

        public KeyManagerSet(String userId, char[] password, String certPath) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
            this.userId = userId;

            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream fis = new FileInputStream(certPath);
            ks.load(fis, password);
            fis.close();

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks, password);
            this.keyManager = kmf.getKeyManagers()[0];
        }

        public String getUserId() {
            return userId;
        }

        public KeyManager getKeyManager() {
            return keyManager;
        }
    }

    public static void main(String[] args) {
    }
}