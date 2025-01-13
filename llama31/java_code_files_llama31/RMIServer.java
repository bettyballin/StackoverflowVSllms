/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] stringArray) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry created on port 1099");
        }
        catch (Exception exception) {
            System.err.println("Error creating RMI registry: " + exception.getMessage());
        }
    }
}
