import java.lang.String;
// Example of how to use Java's built-in profiling API
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Profiler_1 {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        threadMXBean.setThreadContentionMonitoringEnabled(true);

        // Your application code here...

        threadMXBean.dumpAllThreads(true, true);
    }
}