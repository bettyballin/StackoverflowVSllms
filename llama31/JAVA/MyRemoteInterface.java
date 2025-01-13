import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteInterface extends Remote {
    String sayHello() throws RemoteException;
}

public class Main {
    public static void main(String[] args) {
    }
}