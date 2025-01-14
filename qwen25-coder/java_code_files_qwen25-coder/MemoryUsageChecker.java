import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;

public class MemoryUsageChecker {
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("java.lang:type=Memory");
        CompositeData heapMemoryUsage = (CompositeData) mbs.getAttribute(name, "HeapMemoryUsage");
        Long usedHeap = (Long) heapMemoryUsage.get("used");
        Long maxHeap = (Long) heapMemoryUsage.get("max");

        System.out.println("Used Heap Memory: " + usedHeap / 1024 / 1024 + " MB");
        System.out.println("Max Heap Memory: " + maxHeap / 1024 / 1024 + " MB");
    }
}