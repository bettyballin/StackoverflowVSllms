/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryProfiler {
    public static void main(String[] stringArray) {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage memoryUsage2 = memoryMXBean.getNonHeapMemoryUsage();
        while (true) {
            System.out.println("Heap memory usage: " + memoryUsage.getUsed() + " bytes");
            System.out.println("Non-heap memory usage: " + memoryUsage2.getUsed() + " bytes");
            try {
                Thread.sleep(1000L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                continue;
            }
            break;
        }
    }
}
