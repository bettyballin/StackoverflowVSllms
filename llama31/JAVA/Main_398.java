import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Main_398 {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long uptime = runtimeMXBean.getUptime();
        System.out.println("JVM uptime: " + uptime + " milliseconds");
    }
}