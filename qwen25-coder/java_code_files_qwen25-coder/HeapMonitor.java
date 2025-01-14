import java.lang.String;
public class HeapMonitor {
    public static void main(String[] args) {
        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory(); 

        // Get maximum size of heap in bytes. The Java VM will never use more memory than this value.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes.
        long heapFreeSize = Runtime.getRuntime().freeMemory(); 
        
        double usedHeapRatio = 1 - ((double)heapFreeSize / (double)(heapSize));
        double freeHeapPercentage = (heapFreeSize * 100.0) / heapSize;
        
        System.out.printf("Used Heap Ratio: %.2f%%, Free Heap Percentage: %.2f%%\n", usedHeapRatio*100, freeHeapPercentage);
    }
}