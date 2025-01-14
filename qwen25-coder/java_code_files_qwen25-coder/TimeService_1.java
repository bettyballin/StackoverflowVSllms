import java.lang.String;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class TimeService_1 {
    // Example function to display current time with timezone information
    public String getCurrentTimeWithTimeZone() {
        // Use UTC for consistency and clarity
        return LocalDateTime.now(ZoneOffset.UTC).toString();
    }

    // Display both for user clarity if necessary
    public String getCurrentTimesBothZones() {
        ZoneId gmtZone = ZoneId.of("GMT");
        ZonedDateTime currentTimeInGmt = ZonedDateTime.now(gmtZone);
        ZonedDateTime currentTimeInUtc = ZonedDateTime.now(ZoneOffset.UTC);
        return "Current Time in GMT: " + currentTimeInGmt.toString() + "\n" +
               "Current Time in UTC: " + currentTimeInUtc.toString();
    }

    public static void main(String[] args) {
    }
}