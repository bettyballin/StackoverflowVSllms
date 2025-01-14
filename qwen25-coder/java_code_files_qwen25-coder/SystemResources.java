import java.lang.String;
// Example of checking system resources in Java (for understanding the environment)
public class SystemResources {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        System.out.println("Free memory: " + freeMemory);
        System.out.println("Allocated memory: " + allocatedMemory);
        System.out.println("Max memory: " + maxMemory);
    }
}