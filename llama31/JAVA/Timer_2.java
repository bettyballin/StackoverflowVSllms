import java.lang.String;

public class Timer_2_2 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // your function call here
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }
}