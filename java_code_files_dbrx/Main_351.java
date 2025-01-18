import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.commons.httpclient.GetMethod;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;

public class Main {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        String host = "your_host_here"; // specify your host
        httpClient.getHostConfiguration().setHost(host, 443); // specify host and port (443 is the standard SSL/TLS port)
        GetMethod getMethod = new GetMethod("/"); // specify the path

        // Create a trust manager that does not validate certificate chains
        TrustManager[] tm = { new TrustEverythingTrustManager() };
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("TLS");
            context.init(null, tm, new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        } // Handle/report exceptions here as necessary

        // Create a custom socket factory
        SecureProtocolSocketFactory socketFactory = new CustomSSLSocketFactory(context);

        // Register the custom protocol with the new socket factory
        Protocol httpsProtocol = new Protocol("https", (ProtocolSocketFactory) socketFactory, 443);
        httpClient.getHostConfiguration().setHost(host, 443, httpsProtocol);

        // Execute the GET method
        try {
            int returnCode = httpClient.executeMethod(getMethod);
            if (returnCode == 200) {
                InputStream in = getMethod.getResponseBodyAsStream();
                // read the response body as an input stream, do whatever you need with it
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } // Handle/report exceptions here as necessary
    }

    // Trust manager that does not validate certificate chains
    public static class TrustEverythingTrustManager implements javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
    }

    // Custom SSL socket factory that uses our SSLContext
    public static class CustomSSLSocketFactory implements SecureProtocolSocketFactory {
        private SSLContext sslContext;

        public CustomSSLSocketFactory(SSLContext sslContext) {
            this.sslContext = sslContext;
        }

        public Socket createSocket(String host, int port) throws IOException {
            return sslContext.getSocketFactory().createSocket(host, port);
        }

        public Socket createSocket(String host, int port, InetAddress localAddress, int localPort)
                throws IOException {
            return sslContext.getSocketFactory().createSocket(host, port, localAddress, localPort);
        }

        public Socket createSocket(String host, int port, InetAddress localAddress, int localPort,
                                   HttpConnectionParams params)
                throws IOException {
            if (params == null) {
                throw new IllegalArgumentException("Parameters may not be null");
            }
            int timeout = params.getConnectionTimeout();
            Socket socket = sslContext.getSocketFactory().createSocket();
            socket.bind(new InetSocketAddress(localAddress, localPort));
            socket.connect(new InetSocketAddress(host, port), timeout);
            return socket;
        }

        public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
                throws IOException {
            return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
        }
    }
}