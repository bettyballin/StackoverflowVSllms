import java.lang.String;
public class Benchmark {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            // Some performance-critical code
            int result = i * 2;
        }
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
    }
}