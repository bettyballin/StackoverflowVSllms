import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

public class Main_623 {
    public static void main(String[] args) {
        MemoryPoolMXBean heap = ManagementFactory.getMemoryPoolMXBeans().stream()
                .filter(bean -> bean.getName().equals("Java heap"))
                .findFirst()
                .orElseThrow();

        MemoryPoolMXBean permgen = ManagementFactory.getMemoryPoolMXBeans().stream()
                .filter(bean -> bean.getName().equals("Perm Gen") || bean.getName().equals("Metaspace"))
                .findFirst()
                .orElseThrow();

        System.out.println("Max Heap Size: " + heap.getUsage().getMax());
        System.out.println("Max Permgen Size: " + permgen.getUsage().getMax());
    }
}