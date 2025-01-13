import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ssl.SslContextFactory;
import org.eclipse.jetty.server.ssl.SslSelectorChannelConnector;

public class SecureServer {
    public static void main(String[] args) throws Exception {
        // Create an SSL context factory
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setKeyStorePath("path/to/keystore.jks");
        sslContextFactory.setKeyStorePassword("password");
        sslContextFactory.setTrustStorePath("path/to/truststore.jks");
        sslContextFactory.setTrustStorePassword("password");

        // Create an SSL connector
        SslSelectorChannelConnector sslConnector = new SslSelectorChannelConnector(sslContextFactory);
        sslConnector.setPort(8443);

        // Create a server with the SSL connector
        Server server = new Server();
        server.addConnector(sslConnector);

        // Start the server
        server.start();
        server.join();
    }
}