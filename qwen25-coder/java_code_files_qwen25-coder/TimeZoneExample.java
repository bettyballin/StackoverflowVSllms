import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneExample {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("z");
        sdf.setTimeZone(TimeZone.getTimeZone("JST"));
        System.out.println(sdf.format(new Date()));
    }
}