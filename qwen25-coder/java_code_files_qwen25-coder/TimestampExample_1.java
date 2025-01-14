import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;

public class TimestampExample_1 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2007, 9, 23);
        Timestamp timestamp = Timestamp.valueOf(localDate.atStartOfDay());
        System.out.println(timestamp);
    }
}