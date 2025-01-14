import java.lang.String;
import java.util.logging.Logger;

public class LoggerHelper {
    private static final Logger log = Logger.getLogger(LoggerHelper.class.getName());
    private static String input = "Default input";

    static {
        log.info("Starting operation with input: " + input);
    }

    public static void main(String[] args) {
    }
}