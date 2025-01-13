import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.util.Map;
import java.util.HashMap;

public class MultipleKeyStoreSSLSocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory[] socketFactories;
    private final Map<String, SSLSocketFactory> hostToSocketFactory;

    public MultipleKeyStoreSSLSocketFactory(KeyStore[] keyStores, char[][] passwords) throws Exception {
        socketFactories = new SSLSocketFactory[keyStores.length];
        hostToSocketFactory = new HashMap<>();

        for (int i = 0; i < keyStores.length; i++) {
            KeyStore keyStore = keyStores[i];
            char[] password = passwords[i];

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, password);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            socketFactories[i] = sslContext.getSocketFactory();
        }
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        SSLSocketFactory socketFactory = hostToSocketFactory.get(host);
        if (socketFactory == null) {
            // Select the correct socket factory based on the target host
            // You can implement your own logic here
            socketFactory = socketFactories[0]; // default to the first socket factory
        }
        return socketFactory.createSocket(host, port);
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        SSLSocketFactory socketFactory = hostToSocketFactory.get(host);
        if (socketFactory == null) {
            // Select the correct socket factory based on the target host
            // You can implement your own logic here
            socketFactory = socketFactories[0]; // default to the first socket factory
        }
        return socketFactory.createSocket(host, port, localHost, localPort);
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        SSLSocketFactory socketFactory = hostToSocketFactory.get(host.getHostAddress());
        if (socketFactory == null) {
            // Select the correct socket factory based on the target host
            // You can implement your own logic here
            socketFactory = socketFactories[0]; // default to the first socket factory
        }
        return socketFactory.createSocket(host, port);
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        SSLSocketFactory socketFactory = hostToSocketFactory.get(address.getHostAddress());
        if (socketFactory == null) {
            // Select the correct socket factory based on the target host
            // You can implement your own logic here
            socketFactory = socketFactories[0]; // default to the first socket factory
        }
        return socketFactory.createSocket(address, port, localAddress, localPort);
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        SSLSocketFactory socketFactory = hostToSocketFactory.get(host);
        if (socketFactory == null) {
            // Select the correct socket factory based on the target host
            // You can implement your own logic here
            socketFactory = socketFactories[0]; // default to the first socket factory
        }
        return socketFactory.createSocket(s, host, port, autoClose);
    }

    public static void main(String[] args) {
    }
}