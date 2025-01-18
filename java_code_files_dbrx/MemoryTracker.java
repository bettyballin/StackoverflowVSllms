import java.lang.String;
public class MemoryTracker {
    long memTotal = Runtime.getRuntime().totalMemory(); // Total available heap memory
    long memFree = Runtime.getRuntime().freeMemory();   // Free heap memory currently available for new objects (initially this would be almost total memory)
    long memUsed;                  // Used heap memory by the program

    public MemoryTracker() {
        memUsed = memTotal - memFree;
    }

    public static void main(String[] args) {
    }
}