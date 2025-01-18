import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) {
        try {
            MyRemoteInterface obj = new MyImplementation();
            obj = (MyRemoteInterface) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            registry.bind("ServiceName", obj);
            // Remember to call 'UnicastRemoteObject.unexportObject(obj, true);' when done with the object to avoid leaks!
            System.out.println("Service bound");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define the remote interface
    public interface MyRemoteInterface extends Remote {
        String sayHello() throws RemoteException;
    }

    // Implement the remote interface
    public static class MyImplementation implements MyRemoteInterface {
        @Override
        public String sayHello() throws RemoteException {
            return "Hello, world!";
        }
    }
}