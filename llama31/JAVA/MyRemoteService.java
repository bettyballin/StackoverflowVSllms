import java.lang.String;
import java.lang.Exception;
import java.lang.Throwable;
import java.rmi.RemoteException;
import java.util.logging.Logger;

// Server-side
public class MyRemoteService {
    private static final Logger log = Logger.getLogger(MyRemoteService.class.getName());

    public void myMethod() throws ServerException {
        try {
            // implementation
        } catch (Exception e) {
            log.severe(e.getMessage());
            throw new ServerException("Internal server error", e);
        }
    }
}

// Client-side
public class MyClient {
    private static final Logger log = Logger.getLogger(MyClient.class.getName());
    private MyRemoteService myRemoteService;

    public MyClient(MyRemoteService myRemoteService) {
        this.myRemoteService = myRemoteService;
    }

    public void callMyMethod() {
        try {
            myRemoteService.myMethod();
        } catch (ServerException e) {
            log.severe(e.getMessage());
            displayErrorMessage("Internal server error");
        }
    }

    private void displayErrorMessage(String message) {
        System.out.println(message);
    }
}

// Custom exception
public class ServerException extends RemoteException {
    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void main(String[] args) {
        MyRemoteService myRemoteService = new MyRemoteService();
        MyClient myClient = new MyClient(myRemoteService);
        myClient.callMyMethod();
    }
}