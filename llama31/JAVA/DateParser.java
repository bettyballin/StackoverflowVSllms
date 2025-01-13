import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static void main(String[] args) {
        // ISO 8601
        String isoDate = "2022-07-25T14:30:00Z";
        DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime isoDateTime = LocalDateTime.parse(isoDate, isoFormatter);

        // RFC 3339
        String rfcDate = "2022-07-25T14:30:00.000Z";
        DateTimeFormatter rfcFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime rfcDateTime = LocalDateTime.parse(rfcDate, rfcFormatter);
    }
}