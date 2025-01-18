// A.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface A extends Remote {
    void setCallback(IClient client) throws RemoteException;
}