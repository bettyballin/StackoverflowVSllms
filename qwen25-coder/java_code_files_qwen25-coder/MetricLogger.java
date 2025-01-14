import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import com.sun.management.OperatingSystemMXBean;

public class MetricLogger {
    private String logPath;
    private boolean monitorExecutionTime = false;
    private boolean monitorMemoryUsage = false;
    private boolean monitorCpuLoad = false;

    private long startTime;
    private long startUsedMem;
    private double startSysCPU;
    private long startProcCPU;

    public MetricLogger(String logPath) {
        this.logPath = logPath;
    }

    public void setLogPath(String pathToLogFile) {
        this.logPath = pathToLogFile;
    }

    public void monitor(boolean executionTime, boolean memoryUsage, boolean cpuLoad) {
        this.monitorExecutionTime = executionTime;
        this.monitorMemoryUsage = memoryUsage;
        this.monitorCpuLoad = cpuLoad;
    }

    public void start() {
        if (monitorExecutionTime) {
            startTime = System.nanoTime();
        }
        if (monitorMemoryUsage) {
            Runtime runtime = Runtime.getRuntime();
            startUsedMem = runtime.totalMemory() - runtime.freeMemory();
        }
        if (monitorCpuLoad) {
            OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
            startSysCPU = osBean.getSystemCpuLoad();
            startProcCPU = threadBean.getCurrentThreadCpuTime();
        }
    }

    public void stop() {
        StringBuilder logData = new StringBuilder();

        if (monitorExecutionTime) {
            long endTime = System.nanoTime();
            logData.append("Execution Time: ").append(endTime - startTime).append(" ns\n");
        }
        if (monitorMemoryUsage) {
            Runtime runtime = Runtime.getRuntime();
            long endUsedMem = runtime.totalMemory() - runtime.freeMemory();
            logData.append("Memory Usage: ").append(endUsedMem - startUsedMem).append(" bytes\n");
        }
        if (monitorCpuLoad) {
            OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
            double endSysCPU = osBean.getSystemCpuLoad();
            long endProcCPU = threadBean.getCurrentThreadCpuTime();
            logData.append("System CPU Load: ").append(endSysCPU - startSysCPU).append("\n");
            logData.append("Process CPU Time: ").append(endProcCPU - startProcCPU).append(" ns\n");
        }

        try (FileWriter writer = new FileWriter(logPath, true)) {
            writer.write(logData.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}