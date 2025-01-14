import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface MyBCRmiInterface extends Remote {
    public String myRemoteMethod(String param) throws RemoteException;
}

public class MyBCRmiServer extends UnicastRemoteObject implements MyBCRmiInterface {

    protected MyBCRmiServer() throws RemoteException {
        super();
    }

    @Override
    public String myRemoteMethod(String param) throws RemoteException {
        // Implement the business component call here.
        return "Processed: " + param;
    }

    public static void main(String[] args) {
        try {
            MyBCRmiServer obj = new MyBCRmiServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("MyService", obj);
            System.out.println("MyBC Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}