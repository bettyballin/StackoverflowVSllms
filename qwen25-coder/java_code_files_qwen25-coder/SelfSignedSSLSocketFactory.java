import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.security.KeyStore;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class SelfSignedSSLSocketFactory extends SSLSocketFactory {

    private static final String TAG = "SelfSignedSSLSocketFactory";

    private SSLContext sslContext;

    public SelfSignedSSLSocketFactory(InputStream keyStore, char[] passphrase) throws Exception {

        KeyStore trusted = KeyStore.getInstance(KeyStore.getDefaultType());
        trusted.load(keyStore, passphrase);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trusted);

        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
    }

    @Override
    public Socket createSocket() throws IOException {
        return sslContext.getSocketFactory().createSocket();
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        return sslContext.getSocketFactory().createSocket(s, host, port, autoClose);
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        return sslContext.getSocketFactory().createSocket(host, port);
    }

    @Override
    public Socket createSocket(String host_name, int port, InetAddress local_host, int local_port) throws IOException, UnknownHostException {
        return sslContext.getSocketFactory().createSocket(host_name, port, local_host, local_port);
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return sslContext.getSocketFactory().getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return sslContext.getSocketFactory().getSupportedCipherSuites();
    }

    public static void main(String[] args) {
    }
}