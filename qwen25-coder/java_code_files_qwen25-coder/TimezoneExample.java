import java.lang.String;
import java.time.ZoneId;

public class TimezoneExample {
    public static void main(String[] args) {
        String ianaId = "Pacific/Marquesas";
        ZoneId zoneId = ZoneId.of(ianaId);
        System.out.println("Zone ID: " + zoneId);
    }
}