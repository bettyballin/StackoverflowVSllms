import java.lang.String;
public class Benchmark_1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            // Perform some CPU-intensive task
            Math.sqrt(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + "ms");
    }
}