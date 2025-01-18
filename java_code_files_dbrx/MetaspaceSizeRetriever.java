import java.lang.management.*;
public class MetaspaceSizeRetriever {
    public static void main(String[] args) {
        MemoryPoolMXBean memoryPoolMXBean = ManagementFactory.getMemoryPoolMXBeans().stream()
                .filter(e -> e.getName().contains("Metaspace"))
                .findFirst().orElse(null);
        if (memoryPoolMXBean != null) {
            long maxMetaspaceSize = memoryPoolMXBean.getUsage().getMax(); // return in bytes
            System.out.println("Max Metaspace Size: " + maxMetaspaceSize + " bytes");
        }
    }
}