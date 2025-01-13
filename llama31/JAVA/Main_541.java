import java.lang.String;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main_541 {
    public static void main(String[] args) {
        // Define the date
        LocalDate date = LocalDate.of(2022, 12, 31);

        // Convert the date to an Instant in UTC
        Instant instant = date.atStartOfDay(ZoneId.of("UTC")).toInstant();

        // Get the timestamp
        long timestamp = instant.toEpochMilli();

        System.out.println(timestamp);
    }
}