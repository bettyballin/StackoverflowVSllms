import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Main_106 {
    public static void main(String[] args) {
        RmiServiceClient client = new RmiServiceClient(MyRemoteService.class, 1099, "MyService");
        try {
            MyRemoteService serviceForHostA = client.getServiceForHost("hostA.com");
            // Use the serviceForHostA object to interact with remote service on hostA

            MyRemoteService serviceForHostB = client.getServiceForHost("hostB.com");
            // Use the serviceForHostB object to interact with remote service on hostB
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Define the MyRemoteService interface
interface MyRemoteService extends Remote {
    // Methods that the remote service provides
    public void someMethod() throws RemoteException;
}

// Define the RmiServiceClient class
class RmiServiceClient {
    private Class<?> remoteInterface;
    private int port;
    private String serviceName;

    public RmiServiceClient(Class<?> remoteInterface, int port, String serviceName) {
        this.remoteInterface = remoteInterface;
        this.port = port;
        this.serviceName = serviceName;
    }

    public MyRemoteService getServiceForHost(String host) throws Exception {
        // Implement the logic to get the remote service from the host
        // For the purpose of making the code compilable, we'll return a stub implementation
        return new MyRemoteServiceImpl();
    }
}

// Implement a stub for MyRemoteService
class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
    protected MyRemoteServiceImpl() throws RemoteException {
        super();
    }

    public void someMethod() throws RemoteException {
        // Implement the method
        System.out.println("someMethod invoked");
    }
}