import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyBCRmiClient {
    private MyBCRmiInterface stub;

    public MyBCRmiClient() {
        try {
            Registry registry = LocateRegistry.getRegistry(null, 1099);
            stub = (MyBCRmiInterface) registry.lookup("MyService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callRemoteMethod() {
        try {
            String response = stub.myRemoteMethod("test input");
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyBCRmiClient client = new MyBCRmiClient();
        client.callRemoteMethod();
    }
}

interface MyBCRmiInterface extends Remote {
    String myRemoteMethod(String input) throws RemoteException;
}