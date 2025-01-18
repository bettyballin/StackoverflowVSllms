import net.slping.SLPObject;
import net.slping.ServiceLocationManager;
import net.slping.daemon.Daemon;  // Import required classes
import net.slping.listener.*;      // from jSLP

public class Example {
    public static void main(String[] args) throws Exception {   // Main function entry point
        ServiceLocationManager slp = new Daemon();            // Create instance of SLP daemon (service discovery server)
        
        // Implement a suitable SLPDaemonListener to listen for service registrations, etc.
        SLPDaemonListener listener = new SLPDaemonListener() {
            @Override
            public void serviceRegistered(ServiceEvent event) {
                // Implement your code here
                System.out.println("Service registered: " + event.getName());
            }

            @Override
            public void serviceDeregistered(ServiceEvent event) {
                // Implement your code here
                System.out.println("Service deregistered: " + event.getName());
            }

            // Implement other methods as required by the interface
        };

        slp.addListener(listener);                         // Register the daemon's event listener
        
        SLPObject obj1 = new SLPObject("TestService");     // Create an object representing advertised service
        String url = "service:http://localhost/path?key=value";  // Construct URL encoding location of actual networked resource to be registered with OpenSLP. This is a non-trivial process, see http://tools.ietf.org/html/rfc2609#section-3
        
        slp.addAttr(SLPObject.LIFETIME_ATTR, 1);             // Set an arbitrary lease lifetime for the registration (in seconds) [0 = infinite]
        
        slp.registerService("TestService", url, listener::serviceRegistered, obj1); // Register service at URL with a specific registration callback function, and attach additional metadata in form of SLPObject argument
    }
}