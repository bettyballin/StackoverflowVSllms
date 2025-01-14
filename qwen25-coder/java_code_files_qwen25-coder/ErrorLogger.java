import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorLogger {

    private static final Logger logger = Logger.getLogger(ErrorLogger.class.getName());

    static {
        try {
            // Your code here
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Execution failed", e);
        }
    }

    public static void main(String[] args) {
    }
}