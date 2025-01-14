import java.sql.Timestamp;
import java.time.Instant;

public class DateTimeToTimestamp {
    public static void main(String[] args) {
        // Get the current time as an Instant
        Instant instant = Instant.now();

        // Convert to milliseconds since the Unix epoch
        long millis = instant.toEpochMilli();

        // Create a Timestamp from the milliseconds
        Timestamp sqlTimestamp = new Timestamp(millis);

        // Now you can use sqlTimestamp in your prepared statement
    }
}