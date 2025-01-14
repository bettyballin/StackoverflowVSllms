import java.lang.String;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class RMIServer_3 {
    public static void main(String[] args) throws RemoteException {
        // Create an RMI registry on port 1099
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI Registry created on port 1099.");
        } catch (RemoteException e) {
            System.err.println("Could not create registry");
            throw e;
        }
    }
}