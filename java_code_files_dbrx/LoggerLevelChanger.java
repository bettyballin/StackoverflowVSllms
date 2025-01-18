import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.Field;

public class LoggerLevelChanger {

    public void changeLevel(String loggerName, String levelStr) {
        final Level level = Level.toLevel(levelStr); // your desired level here
        Logger log = LogManager.getLogger(loggerName); // get target logger
        if (log instanceof org.apache.logging.log4j.core.Logger) {
            try {
                Field f = org.apache.logging.log4j.core.Logger.class.getDeclaredField("level");  // use the reflection API to change the level
                f.setAccessible(true);
                f.set(log, level);
            } catch (Exception e) {
                log.warn("Exception when setting logger(" + loggerName + ") level to " + levelStr, e);
            }
        } else { // or handle this case in a different way: can't be reconfigured so throw an exception?
            log.error("Logger(" + loggerName + ") is not suitable for changing log level");
        }
    }
}