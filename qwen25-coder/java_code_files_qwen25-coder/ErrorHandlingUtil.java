import java.lang.String;

public class ErrorHandlingUtil {
    static {
        try {
            riskyOperation();
        } catch (SpecificException e) {
            log.error("An error occurred: ", e);
            recoverOrReport(e);
        }
    }

    public static void riskyOperation() throws SpecificException {
        // Implementation goes here
    }

    public static void recoverOrReport(SpecificException e) {
        // Implementation goes here
    }

    public static void main(String[] args) {
    }

    static Logger log = new Logger();
}

class SpecificException extends Exception {
}

class Logger {
    public void error(String message, Exception e) {
        // Implementation goes here
    }
}