import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class MyApp {
    private static final Logger logger = Logger.getLogger(MyApp.class);

    public static void main(String[] args) {
        // If no log4j.xml is found, set a basic console appender with WARN level
        if (!Logger.getRootLogger().getAllAppenders().hasMoreElements()) {
            BasicConfigurator.configure();
            Logger.getRootLogger().setLevel(Level.WARN);
            logger.warn("Using default logging configuration. Please provide log4j.xml for custom configurations.");
        }

        // Your application logic here
    }
}