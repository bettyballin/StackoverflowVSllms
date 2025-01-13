import java.rmi.Remote;
import java.rmi.RemoteException;

// Client-side RMI interface
interface ClientCallback extends Remote {
    void callback(String message) throws RemoteException;
}

// Client-side RMI implementation
class ClientCallbackImpl implements ClientCallback {
    public void callback(String message) {
        System.out.println("Received callback from EJB: " + message);
    }
}

// EJB interface
interface MyEJB {
    void doSomething(ClientCallback callback);
}

// EJB implementation
class MyEJBImpl implements MyEJB {
    @Override
    public void doSomething(ClientCallback callback) {
        // Do some work...
        try {
            callback.callback("Hello from EJB!");
        } catch (RemoteException e) {
            System.err.println("Error invoking callback: " + e.getMessage());
        }
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Create an RMI stub for the client callback
        ClientCallback callback = new ClientCallbackImpl();

        // Create an instance of the EJB implementation
        MyEJB ejb = new MyEJBImpl();

        // Pass the RMI stub to the EJB
        ejb.doSomething(callback);
    }
}