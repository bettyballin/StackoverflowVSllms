import java.lang.String;
public class JITExample {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000_000; i++) {
            Math.sqrt(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
    }
}