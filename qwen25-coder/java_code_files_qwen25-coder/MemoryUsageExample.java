import java.lang.String;
public class MemoryUsageExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        // Total available memory in JVM
        long totalMemory = runtime.totalMemory();
        // Free memory in JVM
        long freeMemory = runtime.freeMemory();
        // Used memory by application
        long usedMemory = totalMemory - freeMemory;

        System.out.println("Total Memory: " + totalMemory / 1024 + " KB");
        System.out.println("Free Memory: " + freeMemory / 1024 + " KB");
        System.out.println("Used Memory: " + usedMemory / 1024 + " KB");
    }
}