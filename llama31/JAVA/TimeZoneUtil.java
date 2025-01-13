import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneUtil {
    public static void main(String[] args) {
        TimeZone tz = TimeZone.getTimeZone("Japan");
        String tzName = tz.getDisplayName(Locale.US);
        System.out.println(tzName);
    }
}