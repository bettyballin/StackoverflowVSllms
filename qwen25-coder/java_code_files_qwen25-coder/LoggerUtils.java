import java.util.function.Supplier;

public class LoggerUtils {

    public static class Logger {
        public void debug(Supplier<String> msgSupplier) {
            // For demonstration purposes, print the message
            System.out.println(msgSupplier.get());
        }
    }

    private static final Logger LOG = new Logger();
    private static Object largeObject = new Object();

    static {
        LOG.debug(() -> "Large object details: " + largeObject.toString());
    }

    public static void main(String[] args) {
    }
}