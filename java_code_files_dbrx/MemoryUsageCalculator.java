import java.lang.String;
public class MemoryUsageCalculator {
    public static void main(String[] args) {
        long totalMem = Runtime.getRuntime().totalMemory();
        long freeMem = Runtime.getRuntime().freeMemory();

        // Calculate used memory
        long heapUsed = totalMem - freeMem; // in bytes
        System.out.println("Heap used (bytes): " + heapUsed);
    }
}