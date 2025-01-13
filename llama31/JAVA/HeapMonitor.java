import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.HeapMemoryUsage;

public class HeapMonitor {
    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        HeapMemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();

        long totalHeapSize = heapMemoryUsage.getMax();
        long usedHeapSize = heapMemoryUsage.getUsed();
        long freeHeapSize = totalHeapSize - usedHeapSize;

        double freeHeapRatio = ((double) freeHeapSize / totalHeapSize) * 100;

        System.out.println("Free Heap Ratio: " + freeHeapRatio + "%");
    }
}