import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YourRemoteService {
    private static final Logger logger = Logger.getLogger(YourRemoteService.class.getName());

    public Object doSomething() throws RemoteException {
        try {
            return getData();
        } catch (CustomException ex) {
            logger.log(Level.SEVERE, "Error occurred while processing request", ex);
            throw new RemoteException("An error occurred on the server. Please contact support.", null);
        }
    }

    private Object getData() throws CustomException {
        // Implementation of getData
        return null;
    }

    public static void main(String[] args) {
        // You can test the class here if you'd like
    }

    public static class CustomException extends Exception {
        public CustomException() {
            super();
        }

        public CustomException(String message) {
            super(message);
        }

        public CustomException(String message, Throwable cause) {
            super(message, cause);
        }

        public CustomException(Throwable cause) {
            super(cause);
        }
    }
}