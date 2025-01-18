import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

public class Main {
    public static void main(String[] args) {
        MemoryPoolMXBean memoryPoolMXBean = null;
        for (MemoryPoolMXBean mxBean : ManagementFactory.getMemoryPoolMXBeans()) {
            if (mxBean.getName().equals("PS Perm Gen")) {
                memoryPoolMXBean = mxBean;
                break;
            }
        }
        if (memoryPoolMXBean != null) {
            long maxPermSize = memoryPoolMXBean.getUsage().getMax(); // returns in bytes
            // You can use maxPermSize here
            System.out.println("Max Perm Size: " + maxPermSize + " bytes");
        }
    }
}