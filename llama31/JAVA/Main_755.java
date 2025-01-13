import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main_755 {
    public static void main(String[] args) {
        // Create a ZonedDateTime object to mimic TIMESTAMPTZ at a specific timezone
        ZoneId zoneId = ZoneId.systemDefault(); // Using system default timezone
        ZonedDateTime zdt = ZonedDateTime.now(zoneId);

        // Format the output to resemble Timestamp format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedDateTime = zdt.format(formatter);

        System.out.println(formattedDateTime);
    }
}