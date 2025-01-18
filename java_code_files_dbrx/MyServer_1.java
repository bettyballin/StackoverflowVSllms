import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.RMIServerSocketFactory;
import java.net.ServerSocket;
import java.io.IOException;

public class MyServer {

    public static void main(String[] args) {
        try {
            // Create the remote object
            MyRemoteObject obj = new MyRemoteObject();

            // Export the remote object with custom server socket factory
            MyRemoteInterface stub = (MyRemoteInterface) UnicastRemoteObject.exportObject(obj, 0, null, new MySocketFactory());

            // Bind the remote object to the RMI Registry
            Naming.rebind("//localhost:1099/myremoteobject", stub);
            
            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Define the remote interface
interface MyRemoteInterface extends Remote {
    String sayHello() throws RemoteException;
}

// Implement the remote interface
class MyRemoteObject implements MyRemoteInterface {

    public MyRemoteObject() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
}

// Custom server socket factory
class MySocketFactory implements RMIServerSocketFactory {

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        // Create and return a server socket
        return new ServerSocket(port);
    }
}