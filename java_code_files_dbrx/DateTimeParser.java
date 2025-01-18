import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {
    // this is an example of a function converting string to java.time.LocalDateTime
    private static LocalDateTime createLocalDateTimeFromString(String timeAsString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(timeAsString, formatter);
    }

    public static void main(String[] args) {
        // You can test the function here
        String timeAsString = "2023-10-01 12:34:56";
        LocalDateTime dateTime = createLocalDateTimeFromString(timeAsString);
        System.out.println(dateTime);
    }
}