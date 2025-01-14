import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.servlet.ServletContextHandler;
import javax.servlet.http.HttpServlet;

public class SSLServerConfigurator {
    Server server = new Server();
    SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();

    public SSLServerConfigurator() {
        sslContextFactory.setKeyStorePath("path/to/keystore.jks");
        sslContextFactory.setKeyStorePassword("yourKeystorePassword");

        ServerConnector sslConnector = new ServerConnector(server,
                new SslConnectionFactory(sslContextFactory, "http/1.1"),
                new HttpConnectionFactory());
        sslConnector.setPort(8443);

        server.addConnector(sslConnector);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Add your servlets here
        context.addServlet(MyServlet.class, "/myServlet");

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SSLServerConfigurator();
    }
}

class MyServlet extends HttpServlet {
    // Your servlet implementation goes here
}