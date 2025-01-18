import java.lang.String;
import java.rmi.RemoteException;

public class RemoteExceptionHandler {
    private static final Logger LOGGER = new Logger();
    {
        try {
            // Some remote method implementation
        } catch (Exception e) {
            LOGGER.error("An unexpected exception occurred", e);
            throw new RemoteException(e); // wrap in a RemoteException and rethrow for client to handle
        }
    }
    public static void main(String[] args) {
    }
    static class Logger {
        void error(String message, Throwable t) {
            System.err.println(message);
            t.printStackTrace();
        }
    }
}