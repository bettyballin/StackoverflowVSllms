import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main_192 {
    public static void main(String[] args) {
        // Store date and time in UTC
        Instant utcNow = Instant.now();
        String utcString = DateTimeFormatter.ISO_INSTANT.format(utcNow);

        // Convert to client's time zone
        ZoneId clientTimeZone = ZoneId.of("America/New_York");
        ZonedDateTime clientDateTime = utcNow.atZone(clientTimeZone);
        String clientString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(clientDateTime);

        System.out.println("UTC: " + utcString);
        System.out.println("Client's time zone: " + clientString);
    }
}