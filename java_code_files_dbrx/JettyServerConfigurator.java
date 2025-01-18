import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.HashSessionCache;
import org.eclipse.jetty.servlet.JspServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServerConfigurator {
    Server jetty = new Server(8080);
    HashSessionManager manager = new HashSessionManager();
    HashSessionCache sessionCache = new HashSessionCache();
    JspServlet jsp = new JspServlet();
    ServletContextHandler context = new ServletContextHandler(jetty, "/", true, false) {
        protected SessionHandler createSessionHandler() {
            return new SessionHandler(manager);
        }
    };
    //... configure session and security etc ...

    public JettyServerConfigurator() {
        context.setContextPath("/");
        ServletHolder holder = new ServletHolder(jsp);
        holder.setInitParameter("classpath", context.getClassPath());
        context.addServlet(holder, "*.jsp");
        jetty.start();
    }

    public static void main(String[] args) {
        new JettyServerConfigurator();
    }
}