import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.*;
import javax.net.ssl.HttpsURLConnection;

public class SSLExample {

    public static void main(String[] args) {
        try {
            SSLContext sslContext;
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(new FileInputStream("path_to_your_jks"), "password".toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), new SecureRandom());

            // Create a custom SocketFactory to be used for HttpURLConnection
            class CustomSSLSocketFactory extends SSLSocketFactory {
                private final SSLContext sslContext;

                public CustomSSLSocketFactory(SSLContext context) {
                    super();
                    this.sslContext = context;
                }

                @Override
                public String[] getDefaultCipherSuites() {
                    return sslContext.getSocketFactory().getDefaultCipherSuites();
                }

                @Override
                public String[] getSupportedCipherSuites() {
                    return sslContext.getSocketFactory().getSupportedCipherSuites();
                }

                @Override
                public Socket createSocket() {
                    try {
                        return sslContext.getSocketFactory().createSocket();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public Socket createSocket(Socket s, String host, int port, boolean autoClose) {
                    try {
                        return sslContext.getSocketFactory().createSocket(s, host, port, autoClose);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public Socket createSocket(String host, int port) {
                    try {
                        return sslContext.getSocketFactory().createSocket(host, port);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public Socket createSocket(String host, int port, java.net.InetAddress localHost, int localPort) {
                    try {
                        return sslContext.getSocketFactory().createSocket(host, port, localHost, localPort);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public Socket createSocket(java.net.InetAddress host, int port) {
                    try {
                        return sslContext.getSocketFactory().createSocket(host, port);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public Socket createSocket(java.net.InetAddress address, int port, java.net.InetAddress localAddress, int localPort) {
                    try {
                        return sslContext.getSocketFactory().createSocket(address, port, localAddress, localPort);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            SSLSocketFactory sslSocketFactory = new CustomSSLSocketFactory(sslContext);
            URL url = new URL("https://host.example.com");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(sslSocketFactory);

            // You can proceed to use the connection as needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}