import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Define the ARemote interface
interface ARemote extends Remote {
    void callBMethod() throws RemoteException;
}

// Define the BRemote interface
interface BRemote extends Remote {
    void setARemote(ARemote aRemote) throws RemoteException;
    void someMethod() throws RemoteException;
    void callAMethod() throws RemoteException;
}

// Define the B class
public class B_2 extends UnicastRemoteObject implements BRemote {
    private ARemote aRemote;

    public B() throws RemoteException {}

    public void setARemote(ARemote aRemote) throws RemoteException {
        this.aRemote = aRemote;
    }

    public void someMethod() throws RemoteException {
        System.out.println("B's someMethod called");
    }

    public void callAMethod() throws RemoteException {
        aRemote.callBMethod();
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}