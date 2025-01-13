import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main_383 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2007, 9, 23);
        ZonedDateTime zdt = date.atStartOfDay(ZoneId.systemDefault());
        Instant instant = zdt.toInstant();
        System.out.println(instant);
    }
}