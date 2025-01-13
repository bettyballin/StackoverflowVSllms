import java.util.logging.Level;
import java.util.logging.Logger;

public class RmiLogging {
    public static void main(String[] args) {
        // Enable RMI logging
        System.setProperty("java.rmi.server.logCalls", "true");
        Logger.getLogger("sun.rmi").setLevel(Level.ALL);
    }
}