import org.apache.catalina.Server;
import org.apache.catalina.ServerFactory;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;

public class Main_205 {
    public static void main(String[] args) {
        // Get the Server instance
        Server server = ServerFactory.getServer();

        // Get the Service instance
        Service service = server.findService("Catalina"); // default service name

        // Get the connectors
        Connector[] connectors = service.findConnectors();

        // Iterate over the connectors and find the secure one
        for (Connector connector : connectors) {
            if (connector.getScheme().equals("https")) {
                int securePort = connector.getPort();
                // use the secure port
                System.out.println("Secure port: " + securePort);
            }
        }
    }
}