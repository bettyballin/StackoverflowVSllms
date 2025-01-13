import java.lang.String;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create a registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry created on port 1099");
        } catch (Exception e) {
            System.err.println("Error creating RMI registry: " + e.getMessage());
        }
    }
}