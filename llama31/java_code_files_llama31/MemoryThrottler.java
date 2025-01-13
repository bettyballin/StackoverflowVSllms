/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryThrottler {
    private static final long MEMORY_LIMIT = 0x40000000L;

    public void throttle() {
        MemoryUsage memoryUsage;
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        while ((memoryUsage = memoryMXBean.getHeapMemoryUsage()).getUsed() <= 0x40000000L) {
        }
        throw new OutOfMemoryError("Memory usage exceeded the limit");
    }

    public static void main(String[] stringArray) {
    }
}
