import java.rmi.Remote;
import java.rmi.RemoteException;

// Define a remote interface for Object2
public interface Object2Interface extends Remote {
    void someMethod() throws RemoteException;
}