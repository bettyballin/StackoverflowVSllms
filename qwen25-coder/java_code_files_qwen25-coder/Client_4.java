import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public interface MyRemoteService extends Remote {
    String performAction(String param) throws RemoteException;
}

public class Client_4 {
    private static MyRemoteService myRemoteService;

    public static void main(String[] args) throws Exception {
        String host = (args.length < 1) ? null : args[0];
        Registry registry = LocateRegistry.getRegistry(host);
        myRemoteService = (MyRemoteService) registry.lookup("MyRemoteService");

        // Call the remote method
        System.out.println(myRemoteService.performAction("test param"));
    }
}