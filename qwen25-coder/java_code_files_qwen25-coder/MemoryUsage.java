import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class MemoryUsage {
    public static void main(String[] args) {
        MemoryMXBean memoryMxBean = ManagementFactory.getMemoryMXBean();
        System.out.println("Heap Init: " + memoryMxBean.getHeapMemoryUsage().getInit());
        System.out.println("Heap Max: " + memoryMxBean.getHeapMemoryUsage().getMax());
        System.out.println("Non-Heap Init: " + memoryMxBean.getNonHeapMemoryUsage().getInit());
        System.out.println("Non-Heap Max: " + memoryMxBean.getNonHeapMemoryUsage().getMax());
    }
}