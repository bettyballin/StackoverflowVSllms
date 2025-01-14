// Exception classes
class MyCustomRemoteException extends Exception {
    public MyCustomRemoteException(String message) {
        super(message);
    }

    public MyCustomRemoteException(String message, Throwable cause) {
        super(message, cause);
    }
}

class SpecificServerException extends Exception {
    public SpecificServerException(String message) {
        super(message);
    }
}

// Logger class
class Logger {
    public static void error(String message, Throwable t) {
        System.err.println(message + t.getMessage());
    }

    public static void warn(String message, Throwable t) {
        System.out.println(message + t.getMessage());
    }
}

// Server Side
interface MyRemoteInterface {
    void performAction() throws MyCustomRemoteException;
}

class MyRemoteService implements MyRemoteInterface {
    public void performAction() throws MyCustomRemoteException {
        try {
            // Action implementation...
            // Simulate an exception for demonstration purposes
            throw new SpecificServerException("Simulated server exception");
        } catch (SpecificServerException e) {
            Logger.error("Error occurred on server: ", e);
            throw new MyCustomRemoteException("Operation failed", e);
        }
    }
}

// Client Side
public class ClientApplication {
    private static MyRemoteInterface myRemoteService = new MyRemoteService();
    
    public void callRemoteMethod() {
        try {
            myRemoteService.performAction();
        } catch (MyCustomRemoteException e) {
            Logger.warn("Received remote exception from server: ", e);
            // Handle the error appropriately...
        }
    }

    public static void main(String[] args) {
        ClientApplication client = new ClientApplication();
        client.callRemoteMethod();
    }
}