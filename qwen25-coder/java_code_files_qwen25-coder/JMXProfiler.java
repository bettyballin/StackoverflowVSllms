import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class JMXProfiler {

    public static void main(String[] args) throws Exception {
        // Obtain an instance of the ThreadMXBean
        final ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();

        if (!threadMxBean.isThreadCpuTimeSupported()) {
            throw new UnsupportedOperationException("This JVM does not support CPU time measurement");
        }

        if (!threadMxBean.isThreadCpuTimeEnabled()) {
            threadMxBean.setThreadCpuTimeEnabled(true);
        }

        long start = System.currentTimeMillis();
        long cpuStart = 0;

        // Assume we know the ID of the thread we're interested in, or we want to monitor all threads
        Thread threadOfInterest = Thread.currentThread(); // For example, the current thread
        long[] threadIds = new long[]{threadOfInterest.getId()};

        threadMxBean.setThreadCpuTimeEnabled(true);
        cpuStart = threadMxBean.getThreadUserTime(threadIds[0]);

        // Simulate some workload
        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }

        long end = System.currentTimeMillis();
        long cpuEnd = threadMxBean.getThreadUserTime(threadIds[0]);
        long elapsedTimeMillis = end - start;
        double elapsedTimeSecs = elapsedTimeMillis / 1000.0;
        double totalCPUTimeInMillisec = (cpuEnd - cpuStart) / 1_000_000;

        System.out.println("Elapsed Time: " + elapsedTimeSecs);
        System.out.println("Total CPU time used by this thread in milliseconds: " + totalCPUTimeInMillisec);

        double cpuUsageInPercentage = (totalCPUTimeInMillisec / elapsedTimeMillis) * 100;
        System.out.println("CPU Usage for the application in percentage: " + cpuUsageInPercentage);
    }
}