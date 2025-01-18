import java.lang.String;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryLauncher {
    static {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        } catch (Exception e) {
            // ignore if Registry already is running
        }
    }
    
    public static void main(String[] args) {
    }
}