import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// RMI interface
public interface MyService extends Remote {
    String sayHello(String name) throws RemoteException;
}

// RMI implementation
public class MyServiceImpl_6_6 implements MyService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}

// RMI client
public class MyClient {
    public static void main(String[] args) {
        try {
            // Create an RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Create a proxy instance
            MyService service = (MyService) registry.lookup("MyService");
            
            // Call the remote method
            String response = service.sayHello("John");
            System.out.println(response);
        } catch (RemoteException e) {
            System.err.println("RemoteException: " + e.getMessage());
        }
    }
}