import java.lang.String;

public class MetricLogger_1_1 {
    public static void main(String[] args) {
        MetricLogger logger = new MetricLogger();
        logger.setLogPath("path/to/log/file");
        logger.monitorExecutionTime(true);
        logger.monitorMemoryUsage(true);
        logger.monitorCpuLoad(true);

        logger.start();
        // code to be measured
        logger.stop();
    }
}

class MetricLogger {
    private String logPath;
    private boolean monitorExecutionTime;
    private boolean monitorMemoryUsage;
    private boolean monitorCpuLoad;

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public void monitorExecutionTime(boolean monitor) {
        this.monitorExecutionTime = monitor;
    }

    public void monitorMemoryUsage(boolean monitor) {
        this.monitorMemoryUsage = monitor;
    }

    public void monitorCpuLoad(boolean monitor) {
        this.monitorCpuLoad = monitor;
    }

    public void start() {
        System.out.println("Logging started");
    }

    public void stop() {
        System.out.println("Logging stopped");
    }
}