import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;

public class JVMMemoryInfo {
    public static void main(String[] args) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        
        long heapMaxSize = memoryMXBean.getHeapMemoryUsage().getMax();
        System.out.println("Maximum Heap Size: " + (heapMaxSize == -1 ? "No limit" : heapMaxSize / 1024 / 1024 + " MB"));
        
        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (pool.getName().toLowerCase().contains("metaspace")) {
                long metaspaceMaxSize = pool.getUsage().getMax();
                System.out.println("Maximum Metaspace Size: " + (metaspaceMaxSize == -1 ? "No limit" : metaspaceMaxSize / 1024 / 1024 + " MB"));
            } else if (pool.getName().toLowerCase().contains("permanent")) { // For Java 7 and below
                long permGenMaxSize = pool.getUsage().getMax();
                System.out.println("Maximum PermGen Size: " + (permGenMaxSize == -1 ? "No limit" : permGenMaxSize / 1024 / 1024 + " MB"));
            }
        }
    }
}