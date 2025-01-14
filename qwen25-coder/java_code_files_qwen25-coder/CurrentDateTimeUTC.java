import java.lang.String;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;

public class CurrentDateTimeUTC {
    public static void main(String[] args) {
        // Using ZonedDateTime in UTC
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneOffset.UTC);
        System.out.println("Current UTC time using ZonedDateTime: " + utcTime);

        // Alternatively, using Instant
        java.time.Instant instant = java.time.Instant.now();
        System.out.println("Current UTC time using Instant: " + instant);
    }
}