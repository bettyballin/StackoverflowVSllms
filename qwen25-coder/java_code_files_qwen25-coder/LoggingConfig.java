import java.lang.String;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;

public class LoggingConfig {
    public static void setupLogging() {
        // Get the logger for the global logging configuration.
        Logger logger = Logger.getLogger("");

        // Remove all current handlers to avoid duplicates
        Handler[] handlers = logger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            // If only console handler exists, just set its level and return
            handlers[0].setLevel(java.util.logging.Level.INFO);
            return;
        } else {
            for (Handler handler : handlers) {
                logger.removeHandler(handler);
            }
        }

        // Create a new console handler with your desired logging level
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(java.util.logging.Level.INFO);

        // Add the handler to the logger
        logger.addHandler(ch);
    }

    public static void main(String[] args) {
        setupLogging();
        // Your application logic here
    }
}