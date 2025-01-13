import java.lang.String;

public class TimeCalculator {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // Your code here
        long endTime = System.currentTimeMillis();
        long timeInSeconds = (endTime - startTime) / 1000;
        System.out.println("Time taken in seconds: " + timeInSeconds);
    }
}