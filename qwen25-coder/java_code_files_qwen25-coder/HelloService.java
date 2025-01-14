import java.lang.String;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class HelloService {
    // Example of simple RMI setup

    public interface Hello extends Remote {
        String sayHello() throws RemoteException;
    }

    public static void main(String[] args) {
    }
}