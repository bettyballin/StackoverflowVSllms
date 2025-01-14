import java.lang.String;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateFormatExample {
    public static void main(String[] args) {
        Instant now = Instant.now();

        // ISO 8601 full date-time with timezone offset
        DateTimeFormatter iso8601Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX").withZone(ZoneOffset.UTC);
        String iso8601Format = iso8601Formatter.format(now);

        // RFC 3339
        DateTimeFormatter rfc3339Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneOffset.UTC);
        String rfc3339Format = rfc3339Formatter.format(now);

        System.out.println("ISO 8601: " + iso8601Format);
        System.out.println("RFC 3339: " + rfc3339Format);
    }
}