import java.lang.String;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main_5 {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // For the current time
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Initial Time : " + now.format(sdf));

        // Reset hour, minute and second to 0
        LocalDateTime midnightTime = now.withHour(0).withMinute(0).withSecond(0);
        System.out.println("Mid-night Time: " + midnightTime.format(sdf) );

        // If you have a ZonedDateTime value for your timestamp, the process would be very similar:
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zNow = ZonedDateTime.now(zone);
        System.out.println("Initial Time : " + sdf.format(zNow));
        // Reset hour, minute and second to 0
        ZonedDateTime zMidnightTime = zNow.withHour(0).withMinute(0).withSecond(0);
        System.out.println("Mid-night Time: " + sdf.format(zMidnightTime));
    }
}