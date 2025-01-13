import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;

public class SystemMonitor {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // CPU usage
        double cpuUsage = osBean.getSystemLoadAverage() / osBean.getAvailableProcessors();
        System.out.println("CPU usage: " + cpuUsage * 100 + "%");

        // Memory usage
        long totalMemory = memoryBean.getHeapMemoryUsage().getMax();
        long freeMemory = memoryBean.getHeapMemoryUsage().getCommitted();
        System.out.println("Memory usage: " + (totalMemory - freeMemory) + "/" + totalMemory + " (" + ((double) (totalMemory - freeMemory) / totalMemory) * 100 + "%)");

        // Disk usage
        File file = new File("/");
        long totalDiskSpace = file.getTotalSpace();
        long freeDiskSpace = file.getUsableSpace();
        System.out.println("Disk usage: " + (totalDiskSpace - freeDiskSpace) + "/" + totalDiskSpace + " (" + ((double) (totalDiskSpace - freeDiskSpace) / totalDiskSpace) * 100 + "%)");
    }
}