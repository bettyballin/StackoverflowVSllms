import java.lang.String;
import java.rmi.RemoteException;

@Stateless
public class MyEJBBean implements MyEJB {
    private RemoteClientInterface callback;

    public void registerCallback(RemoteClientInterface client) throws RemoteException {
        this.callback = client;
    }

    public void performActionAndCallback() throws RemoteException {
        // Perform actions...
        
        // Callback to the client
        if (callback != null) {
            callback.someMethod();
        }
    }
}

interface MyEJB extends EJBObject {
    void registerCallback(RemoteClientInterface client) throws RemoteException;
    void performActionAndCallback() throws RemoteException;

    public static void main(String[] args) {
    }
}

interface RemoteClientInterface extends java.rmi.Remote {
    void someMethod() throws RemoteException;
}

// Minimal stubs to allow compilation
interface EJBObject extends java.rmi.Remote {
}

@interface Stateless {
}