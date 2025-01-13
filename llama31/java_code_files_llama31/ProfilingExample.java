/*
 * Decompiled with CFR 0.152.
 */
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class ProfilingExample {
    public static void main(String[] stringArray) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long l = memoryMXBean.getHeapMemoryUsage().getUsed();
        System.out.println("Heap Memory Used: " + l);
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
        double d = operatingSystemMXBean.getSystemCpuLoad();
        System.out.println("CPU Usage: " + d);
    }
}
