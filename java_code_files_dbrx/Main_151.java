import java.lang.String;
import java.time.*;
import static java.time.ZoneOffset.UTC;

public class Main_151 {
    public static void main(String[] args) {
        String dateInString = "2023-11-26"; // your provided date
        LocalDate localDate = LocalDate.parse(dateInString);
        ZonedDateTime zdt = localDate.atStartOfDay(UTC);
        long timestampMillis = zdt.toInstant().toEpochMilli();
        System.out.println("Timestamp:" + timestampMillis);
    }
}