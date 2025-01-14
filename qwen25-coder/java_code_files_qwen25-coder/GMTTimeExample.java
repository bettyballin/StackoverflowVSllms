import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class GMTTimeExample {
    public static void main(String[] args) {
        // Get the current UTC Date and Time
        LocalDateTime utcDateTime = LocalDateTime.now(ZoneOffset.UTC);
        
        // Alternatively, using ZonedDateTime
        ZonedDateTime utcDate = ZonedDateTime.now(ZoneOffset.UTC);
        
        System.out.println("Current UTC Date and Time (LocalDateTime): " + utcDateTime);
        System.out.println("Current UTC Date and Time (ZonedDateTime): " + utcDate);
    }
}