import java.lang.String;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class ProfilingExample {
    public static void main(String[] args) {
        // Get the Memory MX Bean
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        // Get the heap memory usage
        long heapMemoryUsed = memoryMXBean.getHeapMemoryUsage().getUsed();

        // Print the heap memory usage
        System.out.println("Heap Memory Used: " + heapMemoryUsed);

        // Get the Operating System MX Bean
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        // Get the CPU usage
        double cpuUsage = operatingSystemMXBean.getSystemCpuLoad();

        // Print the CPU usage
        System.out.println("CPU Usage: " + cpuUsage);
    }
}