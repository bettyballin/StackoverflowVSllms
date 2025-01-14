import java.lang.String;
import java.time.LocalTime;
import java.time.Duration;

public class DayProgressPercentage {
    public static void main(String[] args) {
        // Get the current time
        LocalTime now = LocalTime.now();
        
        // Calculate the duration from the start of the day to the current time
        Duration elapsedDuration = Duration.between(LocalTime.MIDNIGHT, now);
        
        // Calculate the total duration in a day
        long totalSecondsInDay = Duration.ofDays(1).getSeconds();
        
        // Calculate the elapsed percentage
        double elapsedPercentage = (elapsedDuration.getSeconds() * 100.0) / totalSecondsInDay;
        
        System.out.printf("Elapsed percentage of the day: %.2f%%\n", elapsedPercentage);
    }
}