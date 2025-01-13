/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

public class Main_623 {
    public static void main(String[] stringArray) {
        MemoryPoolMXBean memoryPoolMXBean2 = ManagementFactory.getMemoryPoolMXBeans().stream().filter(memoryPoolMXBean -> memoryPoolMXBean.getName().equals("Java heap")).findFirst().orElseThrow();
        MemoryPoolMXBean memoryPoolMXBean3 = ManagementFactory.getMemoryPoolMXBeans().stream().filter(memoryPoolMXBean -> memoryPoolMXBean.getName().equals("Perm Gen") || memoryPoolMXBean.getName().equals("Metaspace")).findFirst().orElseThrow();
        System.out.println("Max Heap Size: " + memoryPoolMXBean2.getUsage().getMax());
        System.out.println("Max Permgen Size: " + memoryPoolMXBean3.getUsage().getMax());
    }
}
