import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main_368 {
   public static void main(String[] args) throws Exception {
      ServletHolder holder = new ServletHolder(ServletContainer.class);

      holder.setInitParameter("jersey.config.server.provider.packages", "my.p2p.rest");

      Server server = new Server(8000);

      ServletContextHandler context = new ServletContextHandler();
      context.addServlet(holder, "/resource/*");

      HandlerCollection handlers = new HandlerCollection();
      handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
      server.setHandler(handlers);

      try {
          server.start();
          server.join();
      } finally {
         server.destroy();
      }
   }
}