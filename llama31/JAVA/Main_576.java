import java.lang.String;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main_576 {
    public static void main(String[] args) {
        // Get the current date and time in UTC
        Instant instant = Instant.now();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));

        System.out.println("Current date and time in UTC: " + zdt);
    }
}