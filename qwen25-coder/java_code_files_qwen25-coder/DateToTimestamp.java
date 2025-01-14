import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class DateToTimestamp {
    public static void main(String[] args) {
        // Define a specific date
        LocalDate specificDate = LocalDate.of(2023, 10, 1);

        // Convert LocalDate to Instant at UTC
        Instant instant = specificDate.atStartOfDay().toInstant(ZoneOffset.UTC);

        // Get the timestamp in milliseconds
        long timestampInMilliseconds = instant.toEpochMilli();

        // Compare with System.currentTimeMillis()
        long currentTimeMillis = System.currentTimeMillis();

        System.out.println("Timestamp for 2023-10-01 (UTC): " + timestampInMilliseconds);
        System.out.println("Current system time in milliseconds: " + currentTimeMillis);
    }
}