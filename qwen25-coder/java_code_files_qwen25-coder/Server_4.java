import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;

public class Server_4 {
    public static void main(String[] args) {
        try {
            MyRemoteService stub = new MyRemoteServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("MyRemoteService", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    // Interface definition
    interface MyRemoteService extends Remote {
        // Remote methods
        String sayHello() throws RemoteException;
    }

    // Implementation class
    static class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
        public MyRemoteServiceImpl() throws RemoteException {
            super();
        }

        @Override
        public String sayHello() throws RemoteException {
            return "Hello, world!";
        }
    }
}