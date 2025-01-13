import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

public class LoggerConfigurator {
    private static final Logger logger = Logger.getLogger(LoggerConfigurator.class);

    public static void main(String[] args) {
        logger.addAppender(new FileAppender(new PatternLayout(), "log.txt", false));
    }
}