import java.lang.String;
import java.util.logging.Logger;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class PerformanceMonitor {
    private static final Logger LOGGER = Logger.getLogger(PerformanceMonitor.class.getName());
    private static OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public void logSystemMetrics() {
        double systemCpuLoad = osBean.getSystemCpuLoad();
        double processCpuLoad = osBean.getProcessCpuLoad();
        
        LOGGER.info("System CPU Load: " + systemCpuLoad);
        LOGGER.info("Process CPU Load: " + processCpuLoad);
    }

	public static void main(String[] args) {
	}
}