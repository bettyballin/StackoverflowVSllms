import java.lang.String;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client {
    public interface IClient extends Remote {
        void doSomething(String arg) throws RemoteException;
    }
    public static void main(String[] args) {
    }
}