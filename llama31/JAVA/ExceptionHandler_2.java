import java.lang.String;

// Define a custom exception class
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

// Define an error handler interface
interface ErrorHandler {
    void handleError(String message);
}

public class ExceptionHandler_2_2 {
    public static void main(String[] args) {
        // Throw a RuntimeException
        try {
            throw new RuntimeException("Something went wrong");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Throw a custom exception
        try {
            throw new MyException("Something went wrong");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        // Use a callback or error handler
        ErrorHandler errorHandler = new ErrorHandler() {
            @Override
            public void handleError(String message) {
                System.out.println(message);
            }
        };
        boolean success = false;
        if (!success) {
            errorHandler.handleError("Something went wrong");
        }
    }
}