import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YourClassName {
    private static final Logger LOGGER = LoggerFactory.getLogger(YourClassName.class);  // define a logger

    public static void main(String[] args) {
        LOGGER.trace("Trace log message");   // print detailed information to trace level logs
    }
}