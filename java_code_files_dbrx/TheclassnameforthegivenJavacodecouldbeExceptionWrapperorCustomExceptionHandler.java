import java.lang.String;

public class TheclassnameforthegivenJavacodecouldbeExceptionWrapperorCustomExceptionHandler {

    public static void main(String[] args) throws MyCustomException {
        try {
            // Code that may throw an Exception.
        } catch (Exception ex) {
            LogError(ex);
            throw new MyCustomException("Wrapped message", ex);
        }
    }

    public static void LogError(Exception ex) {
        // Code to log the exception
    }
}

class MyCustomException extends Exception {
    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}