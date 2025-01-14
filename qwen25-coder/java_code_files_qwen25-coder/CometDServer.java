import java.lang.String;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.BayeuxServerImpl;
import org.cometd.server.CometDServlet;

public class CometDServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Create the BayeuxServer instance
        final BayeuxServerImpl bayeux = new BayeuxServerImpl();
        bayeux.initialize();

        // Set the BayeuxServer instance to the context
        context.setAttribute(BayeuxServer.ATTRIBUTE, bayeux);

        // Add CometD servlet to the Jetty server
        ServletHolder cometdServletHolder = new ServletHolder(CometDServlet.class);
        context.addServlet(cometdServletHolder, "/cometd/*");

        server.start();
        server.join();
    }
}