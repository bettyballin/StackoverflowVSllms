import java.lang.String;
public class MemoryAllocationDemo {
    public static void main(String[] args) {
        // Simulate fast allocation using array (similar to TLAB concept)
        long startTime = System.nanoTime();
        Object[] objects = new Object[10_000];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object(); // Fast allocation within TLAB
        }
        long endTime = System.nanoTime();

        System.out.println("Time taken to allocate 10,000 objects: " + (endTime - startTime) + " ns");
    }
}