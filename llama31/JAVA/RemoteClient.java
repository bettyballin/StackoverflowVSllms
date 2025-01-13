import java.rmi.Naming;
import java.rmi.RemoteException;

public class RemoteClient {
    // Use async RMI calls
    public static void main(String[] args) throws Exception {
        RemoteInterface remoteInterface = (RemoteInterface) Naming.lookup("rmi://server:port/service");
        AsyncRemoteInterface asyncRemoteInterface = (AsyncRemoteInterface) remoteInterface;
        asyncRemoteInterface.doSomethingAsync();
    }
}

interface RemoteInterface extends java.rmi.Remote {
    // Add your methods here
}

interface AsyncRemoteInterface extends java.rmi.Remote {
    void doSomethingAsync() throws RemoteException;
}