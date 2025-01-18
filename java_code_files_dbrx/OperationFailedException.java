import java.lang.String;
import java.io.IOException;

// Custom exception class
class OperationFailedException extends Exception {
     public OperationFailedException(String message) {
         super(message);
     }
}

// Additional custom exception classes
class CustomException extends Exception {
}

class SomeOtherThirdPartyException extends Exception {
}

// Main class
public class Main {
    public void processData() throws OperationFailedException {
        try {
            callExternalService(); // this can throw exceptions from 3rd party
                                   // libraries or other custom exceptions.
        } catch (IOException | CustomException | SomeOtherThirdPartyException e) {
            String message = "Failed to process data due to error: " + e.getMessage();
            OperationFailedException wrappedException = new OperationFailedException(message);
            throw wrappedException; // throw a custom exception wrapping the original one
                                    // for better context about what operation failed exactly.
        }
    }

    void callExternalService() throws IOException, CustomException, SomeOtherThirdPartyException {
        // For demonstration purposes, throw an exception
        throw new IOException("Simulated IOException");
    }

    public static void main(String[] args) {
        Main mainObj = new Main();
        try {
            mainObj.processData();
        } catch (OperationFailedException e) {
            System.out.println("Caught exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}