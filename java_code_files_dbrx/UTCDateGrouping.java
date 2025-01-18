import java.lang.String;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class UTCDateGrouping {
    public static void main(String[] args) {
        // Sample timestamp (Long type), assuming milliseconds here
        long timestamp = 1594836207028L;

        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        String dateKey = ldt.format(DateTimeFormatter.ISO_DATE);

        System.out.println("Timestamp: " + timestamp + ", Group By Date: " + dateKey);
    }
}