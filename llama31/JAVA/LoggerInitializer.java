import java.util.logging.Level;
import java.util.logging.LogManager;

public class LoggerInitializer {
    static {
        LogManager.getRootLogger().setLevel(Level.DEBUG);
    }
    public static void main(String[] args) {
    }
}