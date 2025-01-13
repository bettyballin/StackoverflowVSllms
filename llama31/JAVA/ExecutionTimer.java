import java.lang.String;

public class ExecutionTimer {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // code to be measured
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " nanoseconds");
    }
}