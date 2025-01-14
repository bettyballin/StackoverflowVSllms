import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class RMIServerTest {
    public void testRemoteMethods() throws Exception {
        RemoteInterface remoteObject = 
                (RemoteInterface) Naming.lookup("rmi://localhost/MyService");
        
        for (int i = 0; i < 10; i++) {
            // Ensure each call is properly made
            String result = remoteObject.someMethod();
            System.out.println("Result of method call: " + result);
            
            // Optionally, add a small delay to prevent timing issues
            Thread.sleep(50);
        }
    }

    public static void main(String[] args) {
        try {
            RMIServerTest test = new RMIServerTest();
            test.testRemoteMethods();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface RemoteInterface extends Remote {
    String someMethod() throws RemoteException;
}