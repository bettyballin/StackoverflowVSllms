/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;

public class SystemMonitor {
    public static void main(String[] stringArray) {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        double d = operatingSystemMXBean.getSystemLoadAverage() / (double)operatingSystemMXBean.getAvailableProcessors();
        System.out.println("CPU usage: " + d * 100.0 + "%");
        long l = memoryMXBean.getHeapMemoryUsage().getMax();
        long l2 = memoryMXBean.getHeapMemoryUsage().getCommitted();
        System.out.println("Memory usage: " + (l - l2) + "/" + l + " (" + (double)(l - l2) / (double)l * 100.0 + "%)");
        File file = new File("/");
        long l3 = file.getTotalSpace();
        long l4 = file.getUsableSpace();
        System.out.println("Disk usage: " + (l3 - l4) + "/" + l3 + " (" + (double)(l3 - l4) / (double)l3 * 100.0 + "%)");
    }
}
