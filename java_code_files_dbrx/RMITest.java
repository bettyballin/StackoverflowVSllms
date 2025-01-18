import java.rmi.registry.*;
import java.rmi.registry.LocateRegistry;
import junit.framework.TestCase;

public class RMITest extends TestCase {
    private static Registry registry;

    public void setUp() throws Exception {
        if (registry == null) // Create the registry and start the server only once.
            registry = LocateRegistry.createRegistry(1099);
        System.out.println("RMi registry ready.");

        this.startMyServer();  // Or any other method to boot up your application's RMI server.
    }

    public void testMethodOne() {   /* tests */ }

    private void startMyServer() {
        // Implementation here
    }
}