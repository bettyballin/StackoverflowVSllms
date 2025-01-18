import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;

public class DateTimeConverter {
    public static void main(String[] args) {
        LocalDateTime aDateTimeInMyTZ = LocalDate.of(2017, Month.JULY, 4).atStartOfDay(); // My Date-Time in local TZ
        ZonedDateTime utcDateTime = ZonedDateTime.of(aDateTimeInMyTZ, ZoneOffset.UTC); // Convert it to UTC for storage or further use.
    }
}