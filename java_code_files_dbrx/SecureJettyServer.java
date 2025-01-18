public class SecureJettyServer {
    public static void main(String[] args) {
        SslContextFactory factory = new SslContextFactory(); // Set the key/certificate info.
        factory.setKeyStorePath("keystore.jks");
        factory.setKeyStorePassword(System.getProperty("passwd", "password"));
        
        Server server = new Server(); // Create and configure an HTTPS connector using Jetty's HTTP connector factory
        SslSelectChannelConnector sslConnector = new SslSelectChannelConnector(factory);
        sslConnector.setPort(8443);
        server.addConnector(sslConnector);
    }
}