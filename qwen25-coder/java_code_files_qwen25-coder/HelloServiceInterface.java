// Simple example of Java RMI service interface
import java.rmi.Remote;
import java.rmi.RemoteException;

public class HelloServiceInterface {

    public interface Hello extends Remote {
        String sayHello() throws RemoteException;
    }

    public static void main(String[] args) {
    }

}