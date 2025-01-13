import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Define a custom exception class
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class RemoteRequestHandler {
    // Define the getData method that throws CustomException
    public Object getData() throws CustomException {
        // Simulate an exception for demonstration purposes
        throw new CustomException("Something went wrong");
    }

    public Object doSomething() throws RemoteException {
        try {
            return getData();
        } catch (CustomException ex) {
            // Log the exception on the server side
            Logger.getLogger(RemoteRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            
            // Throw a plain RemoteException without chaining the original exception
            throw new RemoteException("Error occurred while processing request");
        }
    }

    public static void main(String[] args) {
    }
}