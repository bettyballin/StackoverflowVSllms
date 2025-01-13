import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * This class sets up a simple Jetty server that listens on port 8000.
 */
public class Main_274_274 {
    public static void main(String[] args) throws Exception {
        // Create a new Jetty server listening on port 8000
        Server server = new Server(8000);

        // Create a servlet context handler with session support
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/"); // Set the context path to the root
        server.setHandler(context); // Set the handler for the server

        // Create a servlet holder for the default servlet
        ServletHolder holder = new ServletHolder("default", DefaultServlet.class);
        context.addServlet(holder, "/*"); // Map the servlet to all paths

        // Start the server and join it to prevent main from exiting
        server.start();
        server.join();
    }
}