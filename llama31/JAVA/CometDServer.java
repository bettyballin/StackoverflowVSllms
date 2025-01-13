import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.BayeuxServerImpl;
import org.cometd.server.CometDServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class CometDServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        BayeuxServer bayeuxServer = new BayeuxServerImpl();
        context.addServlet(new ServletHolder(new CometDServlet(bayeuxServer)), "/cometd/*");

        server.start();
        server.join();
    }
}