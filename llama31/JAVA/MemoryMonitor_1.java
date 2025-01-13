import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import javax.management.MBeanServer;

public class MemoryMonitor_1_1 {
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    MemoryPoolMXBean memoryPoolMXBean = ManagementFactory.getMemoryPoolMXBeans().get(0);
    MemoryUsage usage = memoryPoolMXBean.getUsage();

    public static void main(String[] args) {
        new MemoryMonitor_1();
    }
}