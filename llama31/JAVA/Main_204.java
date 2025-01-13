import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_204 {
    public static void main(String[] args) {
        // Get the logger
        Logger logger = Logger.getLogger("myLogger");

        // Set the log level to FINE (equivalent to DEBUG in Log4j)
        logger.setLevel(Level.FINE);

        // To switch back to INFO
        logger.setLevel(Level.INFO);
    }
}