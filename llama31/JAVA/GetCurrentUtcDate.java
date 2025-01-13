import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class GetCurrentUtcDate {
    public static void main(String[] args) {
        // Get current date in UTC (GMT+0)
        Instant instant = Instant.now();
        ZonedDateTime utcDate = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));
        
        // Optionally, print the UTC date to verify
        System.out.println("Current UTC Date: " + utcDate);
    }
}