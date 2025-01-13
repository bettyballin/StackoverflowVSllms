import java.time.Duration;
import java.time.Instant;

public class Timer_1_1 {
    public static void main(String[] args) {
        Instant start = Instant.now();
        // Your event code here
        Instant end = Instant.now();
        long elapsedTime = Duration.between(start, end).toMillis();
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
    }
}