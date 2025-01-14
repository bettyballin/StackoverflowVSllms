import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.SEVERE); // Only log SEVERE messages
        // or
        logger.setUseParentHandlers(false);  // Disable default console handler if needed
    }
}