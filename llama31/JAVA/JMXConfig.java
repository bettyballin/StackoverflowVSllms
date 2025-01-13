import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class JMXConfig {
    public static void main(String[] args) {
        System.setProperty("com.sun.management.jmxremote", "");
        System.setProperty("com.sun.management.jmxremote.port", "1099");
        System.setProperty("com.sun.management.jmxremote.ssl", "false");
        System.setProperty("com.sun.management.jmxremote.authenticate", "false");

        // Your program logic here...
    }
}