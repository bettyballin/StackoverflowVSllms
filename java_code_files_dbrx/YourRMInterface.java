import java.rmi.*;
import java.util.*; // For HashMap

public interface YourRMInterface extends Remote {
    Map<String, String> remoteGetCustomerNamesAndNumbers() throws RemoteException;
}