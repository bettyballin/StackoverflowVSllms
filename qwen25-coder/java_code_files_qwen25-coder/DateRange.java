import java.lang.String;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateRange {
    public static void main(String[] args) {
        // Input dates in calendar format
        String startDateString = "2023-09-29";
        String endDateString   = "2023-10-01";

        // Convert to LocalDateTime at beginning and end of day
        LocalDate startDateLocal = LocalDate.parse(startDateString);
        LocalDate endDateLocal = LocalDate.parse(endDateString);

        // Convert to Timestamp (midnight) and next day midnight for storage
        ZonedDateTime startTimestamp = startDateLocal.atStartOfDay(ZoneOffset.UTC);
        ZonedDateTime endTimestamp = endDateLocal.atStartOfDay(ZoneOffset.UTC);

        System.out.println("Start Date in UTC: " + startTimestamp);
        System.out.println("End Date in UTC: " + endTimestamp);

        // Example usage: Checking if a given date lies within the range
        LocalDate checkDate = LocalDate.of(2023, 9, 30); // Example date to check
        boolean isWithinRange = !checkDate.isBefore(startDateLocal) && checkDate.isBefore(endDateLocal);
        System.out.println("Is " + checkDate + " within the range? " + isWithinRange);
    }
}