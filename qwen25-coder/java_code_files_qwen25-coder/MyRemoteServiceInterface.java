import java.lang.String;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class MyRemoteServiceInterface {

    public interface MyRemoteService extends Remote {
        String performAction(String param) throws RemoteException;
    }
    
    public static void main(String[] args) {
    }
}