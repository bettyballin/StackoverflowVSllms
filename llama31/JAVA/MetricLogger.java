import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;

public class MetricLogger {
    private String logPath;
    private boolean monitorExecutionTime;
    private boolean monitorMemoryUsage;
    private boolean monitorCpuLoad;

    private long startTime;
    private long initialMemoryUsage;
    private long initialCpuTime;

    public MetricLogger() {
        // default settings
        monitorExecutionTime = true;
        monitorMemoryUsage = true;
        monitorCpuLoad = true;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public void monitorExecutionTime(boolean enable) {
        this.monitorExecutionTime = enable;
    }

    public void monitorMemoryUsage(boolean enable) {
        this.monitorMemoryUsage = enable;
    }

    public void monitorCpuLoad(boolean enable) {
        this.monitorCpuLoad = enable;
    }

    public void start() {
        if (monitorExecutionTime) {
            startTime = System.nanoTime();
        }
        if (monitorMemoryUsage) {
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            initialMemoryUsage = memoryMXBean.getHeapMemoryUsage().getUsed();
        }
        if (monitorCpuLoad) {
            OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            initialCpuTime = operatingSystemMXBean.getProcessCpuTime();
        }
    }

    public void stop() {
        if (monitorExecutionTime) {
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.println("Execution time: " + executionTime + " nanoseconds");
        }
        if (monitorMemoryUsage) {
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            long finalMemoryUsage = memoryMXBean.getHeapMemoryUsage().getUsed();
            long memoryUsed = finalMemoryUsage - initialMemoryUsage;
            System.out.println("Memory used: " + memoryUsed + " bytes");
        }
        if (monitorCpuLoad) {
            OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            long finalCpuTime = operatingSystemMXBean.getProcessCpuTime();
            long cpuTimeUsed = finalCpuTime - initialCpuTime;
            System.out.println("CPU time used: " + cpuTimeUsed + " nanoseconds");
        }
    }

    public static void main(String[] args) {
        MetricLogger metricLogger = new MetricLogger();
        metricLogger.start();
        try {
            Thread.sleep(1000); // wait for 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        metricLogger.stop();
    }
}