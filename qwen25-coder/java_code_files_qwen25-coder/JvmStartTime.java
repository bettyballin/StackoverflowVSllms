import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class JvmStartTime {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long startTime = runtimeMXBean.getStartTime(); // Start time in milliseconds
        long currentTime = System.currentTimeMillis(); // Current time in milliseconds
        long uptimeInMillis = currentTime - startTime;

        System.out.println("JVM has been running for: " + uptimeInMillis + " ms");
    }
}