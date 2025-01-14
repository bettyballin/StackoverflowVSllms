package my.p2p;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class Main_2 {
    public static void main(String[] args) throws Exception {
        // Create a server that listens on port 8000.
        Server server = new Server(8000);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        ServletHolder holderServlet = context.addServlet(ServletContainer.class, "/*");
        holderServlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        holderServlet.setInitParameter("com.sun.jersey.config.property.packages", "my.p2p.rest");

        server.start();
        // Join the server thread with the current thread so that it runs indefinitely.
        server.join();
    }
}