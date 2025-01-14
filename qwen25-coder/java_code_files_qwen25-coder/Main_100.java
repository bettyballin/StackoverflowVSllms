// Example in Java: Converting UTC to a specific time zone e.g., America/New_York
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime localTime = utcTime.withZoneSameInstant(ZoneId.of("America/New_York"));
    }
}