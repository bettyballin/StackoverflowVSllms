import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;
import javax.naming.InitialContext;
import javax.naming.NamingException;

class Client_1 extends UnicastRemoteObject implements RemoteClientInterface, Serializable {

    public Client_1() throws RemoteException {
        super();
    }

    public void someMethod() throws RemoteException {
        // Do something on callback
    }

    public static void main(String[] args) {
        try {
            // Register the client with the RMI registry
            Naming.rebind("rmi://localhost/MyRemoteClient", new Client_1());

            // Get EJB and pass this as a callback
            InitialContext ctx = new InitialContext();
            MyEJB remoteObject = (MyEJB) ctx.lookup("java:comp/env/ejb/MyEJB");
            remoteObject.registerCallback((RemoteClientInterface) Naming.lookup("rmi://localhost/MyRemoteClient"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface RemoteClientInterface extends java.rmi.Remote {
    void someMethod() throws java.rmi.RemoteException;
}

interface MyEJB {
    void registerCallback(RemoteClientInterface client) throws RemoteException;
}