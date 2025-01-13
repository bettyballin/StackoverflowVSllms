import java.lang.String;

public class RuntimePrinter {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Your code here
        long runtime = System.nanoTime() - startTime;
        double runtimeInSeconds = (double) runtime / 1_000_000_000;
        System.out.println("Runtime: " + runtimeInSeconds + " seconds");
    }
}