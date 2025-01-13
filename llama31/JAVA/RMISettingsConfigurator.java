import java.lang.String;
import java.lang.Set;

public class RMISettingsConfigurator {
    static {
        // Enable RMI connection caching
        System.setProperty("sun.rmi.transport.tcp.connectionCache", "true");

        // Set the RMI connection cache size
        System.setProperty("sun.rmi.transport.tcp.connectionCacheSize", "100");
    }

    public static void main(String[] args) {
    }
}