import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

interface IClient extends Remote {
    void setCallback(IClient client) throws RemoteException;
    void doSomething(String arg) throws RemoteException;
}

public class A extends UnicastRemoteObject implements IClient {
    IClient client = null; // to call methods on class B object

    public A() throws RemoteException {
        super();
    }

    public void setCallback(IClient client) throws RemoteException {
        this.client = client;
    }

    @Override
    public void doSomething(String arg) throws RemoteException {
        /*Implement the method*/
        System.out.println("Client said: " + arg);
        // Now use 'client' to call methods on Class B object as per requirement.
    }
}