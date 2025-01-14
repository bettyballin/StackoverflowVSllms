import java.rmi.Remote;
import java.rmi.RemoteException;

public class RmiInterfaces {

    public interface AInterface extends Remote {
        void methodA() throws RemoteException;
    }

    public interface BInterface extends Remote {
        void methodB() throws RemoteException;
    }

    public static void main(String[] args) {
    }

}