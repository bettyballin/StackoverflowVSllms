import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.rmi.server.RMIServerSocketFactory;
import java.net.ServerSocket;
import java.io.IOException;

public class MyRemoteObjectService {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(1099);

        MyRemoteObject obj = new MyRemoteObject();

        // Export the object using custom socket factory
        UnicastRemoteObject.exportObject(obj, 0, null, new KeepAliveRMIServerSocketFactory());

        Naming.rebind("rmi://localhost:1099/MyRemoteObject", obj);
    }
}

class MyRemoteObject extends UnicastRemoteObject implements Remote {
    public MyRemoteObject() throws RemoteException {
        super();
    }

    // Implement remote methods here
}

class KeepAliveRMIServerSocketFactory implements RMIServerSocketFactory {
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        ss.setKeepAlive(true);
        return ss;
    }
}