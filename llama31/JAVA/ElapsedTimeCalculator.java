import java.lang.String;

public class ElapsedTimeCalculator {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // Your event code here
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
    }
}