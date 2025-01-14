import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Define the interface that ImplementorClass implements
interface MyServiceInterface extends java.rmi.Remote {
    // Define any methods that can be called remotely
    String sayHello() throws RemoteException;
}

// Implement the interface
class ImplementorClass extends UnicastRemoteObject implements MyServiceInterface {
    public ImplementorClass() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
}

public class RMIServer_1 {
    public static void main(String[] args) {
        try {
            // Ensure the naming registry is created
            LocateRegistry.createRegistry(1099);
            
            ImplementorClass impl = new ImplementorClass();
            Naming.rebind("rmi://localhost/MyService", impl);
            System.out.println("Server started.");
            
            // Keep the server running to accept client connections
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}