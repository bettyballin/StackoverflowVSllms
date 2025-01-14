import java.rmi.Naming;
import java.rmi.RemoteException;

public class MyRmiServer {
    private String rmiObjectName = "rmi://localhost/MyService";

    public void bindService(MyRemoteServiceImpl service) throws RemoteException {
        try {
            Naming.bind(rmiObjectName, service);

            // Add a shutdown hook
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    Naming.unbind(rmiObjectName);
                    System.out.println("Successfully unbound RMI object.");
                } catch (Exception e) {
                    System.err.println("Failed to unbind RMI object: " + e.getMessage());
                }
            }));
        } catch (Exception e) {
            throw new RemoteException("Failed to bind service", e);
        }
    }

    public static void main(String[] args) throws Exception {
        MyRmiServer server = new MyRmiServer();
        MyRemoteServiceImpl service = new MyRemoteServiceImpl();
        server.bindService(service);

        // Simulate long running process
        Thread.sleep(Long.MAX_VALUE);
    }
}