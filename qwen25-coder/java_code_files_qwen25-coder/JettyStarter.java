import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyStarter {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext webAppContext = new WebAppContext();
        String path = "src/main/webapp";
        webAppContext.setDescriptor(path + "/WEB-INF/web.xml");
        webAppContext.setResourceBase(path);
        webAppContext.setContextPath("/");

        server.setHandler(webAppContext);
        try {
            System.out.println(">>> STARTING EMBEDDED JETTY SERVER <<<");
            server.start();
            server.join();

        } finally {
            server.destroy();
        }
    }
}