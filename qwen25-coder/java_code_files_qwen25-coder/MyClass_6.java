import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.util.logging.Logger;

public class MyClass {
    private static final Logger log = Logger.getLogger(MyClass.class.getName());

    public void myMethod() throws RemoteException {
        try {
            String clientHost = RemoteServer.getClientHost();
            InetAddress clientAddress = InetAddress.getByName(clientHost);
            String clientIPAddress = clientAddress.getHostAddress();
            log.info("remote IP is " + clientIPAddress);
        } catch (ServerNotActiveException e) {
            log.severe("Error accessing remote client details: " + e);
        } catch (UnknownHostException e) {
            log.severe("Unknown host: " + e);
        }
    }
}