import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeConverter {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        Date date = Date.from(instant);
    }
}