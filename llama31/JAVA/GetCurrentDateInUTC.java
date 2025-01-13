import java.util.Date;
import java.util.TimeZone;

public class GetCurrentDateInUTC {
    public static void main(String[] args) {
        // Get current date in UTC (GMT+0)
        Date date = new Date();
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        date.setTime(date.getTime() + utcTimeZone.getOffset(date.getTime()));
        System.out.println("Current date in UTC: " + date);
    }
}