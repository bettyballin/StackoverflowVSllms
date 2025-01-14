import java.util.logging.*;

public class LogSetup {
    public static void main(String[] args) {
        // Get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        
        // Set useParentHandlers to false so that we can fully configure logging here
        logger.setUseParentHandlers(false);

        // Create a console handler with a custom formatter and level
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        consoleHandler.setFilter(record -> (record.getSequenceNumber() % 10 == 0)); // Log every 10th message

        logger.addHandler(consoleHandler);

        // Example logging messages
        for (int i = 0; i < 100; i++) {
            logger.info("Message " + i);
        }
    }
}