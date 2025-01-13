import java.lang.String;

public class TimerUtil {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // your function call here
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " nanoseconds");
    }
}