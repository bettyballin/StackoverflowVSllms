import java.lang.String;
import java.lang.management.ManagementFactory;
import java.time.Duration;

public class JVMUptimeCalculator {
    long jvmStartTime = ManagementFactory.getRuntimeMXBean().getStartTime();
    Duration jvmUptime = Duration.ofMillis(System.currentTimeMillis() - jvmStartTime);

    {
        System.out.println("JVM Uptime: " + jvmUptime);
    }

    public static void main(String[] args) {
        new JVMUptimeCalculator();
    }
}