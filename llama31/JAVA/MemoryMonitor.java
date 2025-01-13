import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class MemoryMonitor {
    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long usedMemory = memoryMXBean.getHeapMemoryUsage().getUsed();
        long totalMemory = memoryMXBean.getHeapMemoryUsage().getMax();

        System.out.println("Used memory: " + usedMemory + " bytes");
        System.out.println("Total memory: " + totalMemory + " bytes");
    }
}