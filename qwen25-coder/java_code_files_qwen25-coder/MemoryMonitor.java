import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class MemoryMonitor {
    public static void main(String[] args) throws Exception {
        MemoryMXBean memoryMxBean = ManagementFactory.getMemoryMXBean();
        
        while (true) {
            long usedMemory = memoryMxBean.getHeapMemoryUsage().getUsed() / 1024 / 1024;
            System.out.println("Used Memory: " + usedMemory + " MB");
            Thread.sleep(5000); // Adjust the sleep time as needed
        }
    }
}