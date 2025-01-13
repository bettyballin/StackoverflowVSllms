import java.time.*;
import java.time.zone.ZoneId;

public class Main_687 {
    public static void main(String[] args) {
        // assume 'eventTimeUtc' is the event time in seconds from midnight UTC
        // and 'userTimezoneId' is the user's timezone ID (e.g., "America/New_York")
        long eventTimeUtc = 1643723400; // example value
        String userTimezoneId = "America/New_York"; // example value

        ZoneId userTimezone = ZoneId.of(userTimezoneId);
        LocalTime userTime = Instant.ofEpochSecond(eventTimeUtc).atZone(userTimezone).toLocalTime();

        System.out.println("User Time: " + userTime);
    }
}