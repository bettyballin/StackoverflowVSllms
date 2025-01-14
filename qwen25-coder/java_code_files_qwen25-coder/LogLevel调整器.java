import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class LogLevel调整器 {
    public static void main(String[] args) {
        // Get the logger instance for your application's package or root logger
        Logger logger = Logger.getLogger("com.yourapp");

        // Set log level to DEBUG (or any other Level)
        logger.setLevel(Level.DEBUG);

        // Log a debug message to verify that the level is set correctly
        if(logger.isDebugEnabled()) {
            logger.debug("Logging level set to DEBUG.");
        }
    }

    public static void changeLogLevel(String loggerName, String levelName) {
        Logger logger = Logger.getLogger(loggerName);
        Level level;
        switch(levelName.toLowerCase()) {
            case "debug":
                level = Level.DEBUG;
                break;
            case "info":
                level = Level.INFO;
                break;
            // Add other cases as needed for different levels
            default:
                System.err.println("Unsupported logging level: " + levelName);
                return;
        }

        logger.setLevel(level);
        System.out.println("Changed log level of \"" + loggerName + "\" to " + levelName);
    }
}