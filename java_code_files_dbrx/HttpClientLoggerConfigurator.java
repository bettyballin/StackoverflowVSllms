import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class HttpClientLoggerConfigurator {

    private Logger logger;
    private ConsoleHandler existingHandler;

    public HttpClientLoggerConfigurator() {
        logger = Logger.getLogger("org.apache.commons.httpclient"); // Replace with the appropriate package name for your version of HttpClient
        existingHandler = (ConsoleHandler) logger.getParent().getHandlers()[0];
        logger.setUseParentHandlers(false);
        existingHandler.setLevel(Level.WARNING);
        FormattableFilter formattableFilter = new FormattableFilter(); // Create a custom formatter that only lets through logs you are interested in
        existingHandler.setFormatter(formattableFilter);
    }

    public static void main(String[] args) {
        new HttpClientLoggerConfigurator();
    }

    class FormattableFilter extends Formatter {
        @Override
        public String format(LogRecord record) {
            // Implement formatting logic here
            return record.getMessage() + "\n";
        }
    }
}