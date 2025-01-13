import java.rmi.registry.LocateRegistry;
import java.rmi.registry.RMIClientSocketFactory;
import java.rmi.registry.RMIServerSocketFactory;

public class Main_592 {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099, null, null);
            System.out.println("RMI registry created successfully");
        } catch (Exception e) {
            System.out.println("Error creating RMI registry: " + e.getMessage());
        }
    }
}