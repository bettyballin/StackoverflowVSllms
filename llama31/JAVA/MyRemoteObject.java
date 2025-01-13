import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

// Define the remote interface
interface MyRemote extends Remote {
    void myMethod() throws RemoteException;
}

// Implement the remote interface
class MyRemoteObject implements MyRemote {
    @Override
    public void myMethod() throws RemoteException {
        System.out.println("My method called");
    }
}

// Define the server class
class MyServer {
    public void send(MyRemote obj) throws RemoteException {
        // Call a method on the remote object
        obj.myMethod();
    }
}

// Define the client class
public class MyClient {
    public static void main(String[] args) throws Exception {
        MyServer server = (MyServer) Naming.lookup("rmi://localhost:1099/MyServer");
        MyRemoteObject obj = new MyRemoteObject();
        server.send(obj);
    }
}