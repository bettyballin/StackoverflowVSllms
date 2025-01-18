import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class MyServer {

    public static void main(String[] args) {
        try {
            A serv = new A(); //creates and exports server impl

            Registry rgsty = LocateRegistry.createRegistry(1099); // create a Registry on this computer if none exist
            Naming.rebind("ABC", serv); // Name the service and register it to RMI registry
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }
}

class A extends UnicastRemoteObject implements Remote {

    protected A() throws RemoteException {
        super();
    }
}