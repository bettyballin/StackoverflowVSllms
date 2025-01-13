import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class YourRemoteObject extends UnicastRemoteObject {
    // ...

    @Override
    public void unreferenced() {
        try {
            Naming.unbind("yourObjectName");
        } catch (Exception e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
    }
}