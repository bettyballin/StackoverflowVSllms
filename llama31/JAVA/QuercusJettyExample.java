import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class QuercusJettyExample {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    WebAppContext context = new WebAppContext();
    context.setContextPath("/");
    context.setWar("path/to/quercus-war-file.war");
    server.setHandler(context);
    server.start();
    server.join(); // add this line to keep the server running
  }
}