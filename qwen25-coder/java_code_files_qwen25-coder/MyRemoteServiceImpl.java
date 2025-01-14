import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface MyRemoteService extends Remote {
    String performAction(String param) throws RemoteException;
}

public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
    protected MyRemoteServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String performAction(String param) throws RemoteException {
        // Implement your business logic here
        return "Action performed with param: " + param;
    }

    public static void main(String[] args) {
        // You can instantiate and use your service here if needed
    }
}