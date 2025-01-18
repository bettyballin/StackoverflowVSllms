import java.rmi.RemoteException;
import java.util.logging.Logger;

public class RemoteLogger {
    private static final Logger log = Logger.getLogger(RemoteLogger.class.getName());

    public void myMethod() throws RemoteException {
        CustomSecurityManager csm = (CustomSecurityManager) System.getSecurityManager();
        log.info("remote IP is " + csm.getSecurityContextFromCaller());
    }

    public static void main(String[] args) {
        // Set the security manager to a new instance of CustomSecurityManager
        System.setSecurityManager(new CustomSecurityManager());
        RemoteLogger rl = new RemoteLogger();
        try {
            rl.myMethod();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

class CustomSecurityManager extends SecurityManager {
    public String getSecurityContextFromCaller() {
        // Placeholder implementation
        return "CallerSecurityContext";
    }
}