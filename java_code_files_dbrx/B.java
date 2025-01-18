import java.rmi.*;
import java.rmi.registry.*;

public class B implements IClient {
    A serv = null; // the Remote Object reference for Class A's object

    public void setRemoteObject(A obj) throws RemoteException {
        this.serv = obj;
    }

    @Override
    public void doSomething(String arg) throws RemoteException {
        /* implement the method */
        serv.doSomething("Hi from Client"); // Call method on Class A's object
    }

    public static void main(String[] args) {
    }
}

interface IClient {
    void doSomething(String arg) throws RemoteException;
}

class A {
    public void doSomething(String arg) throws RemoteException {
        // Implementation here
    }
}