import java.lang.String;
public class StopwatchTimer {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // your function call here
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime; // measures the time in milliseconds
        System.out.println("Duration: " + duration + " milliseconds");
    }
}