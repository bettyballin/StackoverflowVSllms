import java.lang.String;
import java.time.*; // Java 8 Date and Time API

public class Main_172 {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("Current date/time in GMT: " + zdt);
    }
}