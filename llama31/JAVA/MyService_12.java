import java.rmi.Remote;
import java.rmi.RemoteException;

public class MyService_12_12 {
    public interface MyService extends Remote {
        String sayHello(String name) throws RemoteException;
        int add(int a, int b) throws RemoteException;
    }

    public static void main(String[] args) {
    }
}