import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

interface BRemote extends Remote {
    void someMethod() throws RemoteException;
}

interface ARemote extends Remote {
    void setBRemote(BRemote bRemote) throws RemoteException;
    void callBMethod() throws RemoteException;
}

public class A_7_7 extends UnicastRemoteObject implements ARemote {
    private BRemote bRemote;

    public A_7() throws RemoteException {}

    public void setBRemote(BRemote bRemote) throws RemoteException {
        this.bRemote = bRemote;
    }

    public void callBMethod() throws RemoteException {
        bRemote.someMethod();
    }

    public static void main(String[] args) {
    }
}