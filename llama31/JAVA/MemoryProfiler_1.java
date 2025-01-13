import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class MemoryProfiler_1_1 {
    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long initialMemoryUsage = memoryMXBean.getHeapMemoryUsage().getUsed();
        // code to be measured
        long finalMemoryUsage = memoryMXBean.getHeapMemoryUsage().getUsed();
        long memoryUsed = finalMemoryUsage - initialMemoryUsage;
        System.out.println("Memory used: " + memoryUsed);
    }
}