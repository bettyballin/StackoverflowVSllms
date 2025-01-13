import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.RemoteException;

// Assuming CustomException and.getData() are defined elsewhere in the codebase
class CustomException extends Exception {
    public Throwable getCause() {
        return null; // Replace with actual cause
    }
}

class MyClass {}

public class RemoteExceptionHandler {
    public Object doSomething() throws RemoteException {
        try {
            return getData();
        } catch (CustomException ex) {
            // Log the original exception on the server side
            Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, ex.getCause());
            
            // Throw a plain RemoteException without chaining the original exception
            throw new RemoteException("Error occurred while processing request");
        }
    }

    // Assuming getData() is defined elsewhere in the codebase
    public Object getData() throws CustomException {
        // Replace with actual implementation
        return null;
    }

    public static void main(String[] args) {
    }
}