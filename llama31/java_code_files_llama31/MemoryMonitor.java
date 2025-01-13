/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class MemoryMonitor {
    public static void main(String[] stringArray) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long l = memoryMXBean.getHeapMemoryUsage().getUsed();
        long l2 = memoryMXBean.getHeapMemoryUsage().getMax();
        System.out.println("Used memory: " + l + " bytes");
        System.out.println("Total memory: " + l2 + " bytes");
    }
}
