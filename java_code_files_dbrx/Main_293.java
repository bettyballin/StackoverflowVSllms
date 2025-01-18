import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String iso_format = "2019-12-31T15:06:48Z";
        Instant instantFromISO = Instant.parse(iso_format);   // works for RFC 3339 too
        ZonedDateTime zdt = ZonedDateTime.parse("2019-12-31T15:06:48+00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssxx"));  // works for RFC 3339

        // Optional: Print the results
        System.out.println("Instant: " + instantFromISO);
        System.out.println("ZonedDateTime: " + zdt);
    }
}