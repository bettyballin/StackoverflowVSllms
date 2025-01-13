import java.lang.String;

public class ExecutionTimeCalculator {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // code to measure
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " nanoseconds");
    }
}