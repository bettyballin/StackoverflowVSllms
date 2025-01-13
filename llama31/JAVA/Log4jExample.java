import org.apache.log4j.Logger;

public class Log4jExample {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Log4jExample.class);
        // You can now use the logger
        log.info("This is an info message");
    }
}