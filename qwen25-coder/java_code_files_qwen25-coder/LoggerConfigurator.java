import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import java.io.IOException;

public class LoggerConfigurator {
    static Logger logger = Logger.getLogger(LoggerConfigurator.class);

    static {
        try {
            logger.addAppender(new FileAppender(new PatternLayout(), "log.txt", false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}