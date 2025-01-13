import java.lang.String;
import java.lang.Set;
import java.rmi.Naming;
import java.rmi.server.RMISocketFactory;

// Assuming YourCustomHttpTunnelingSocketFactory and YourRmiService are defined elsewhere
public class RmiHttpTunnelingConfigurator {
    public static void main(String[] args) {
        // Set system properties for HTTP tunneling
        System.setProperty("java.rmi.server.hostname", "your-http-server-hostname");
        // Optionally, set the port if it's not the default
        // System.setProperty("java.rmi.server.port", "8080");

        // Assuming you have an RMISocketFactory that knows how to do HTTP tunneling
        RMISocketFactory.setSocketFactory(new YourCustomHttpTunnelingSocketFactory());

        // Now, you can lookup your RMI service as usual
        String lookupName = "rmi://your-http-server-hostname:8080/YourRmiServiceName";
        try {
            YourRmiService service = (YourRmiService) Naming.lookup(lookupName);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}