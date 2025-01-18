import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormatterUK {
    TimeZone ukTZ = TimeZone.getTimeZone("Europe/London");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz", Locale.US);
    Date dateObj = new Date();
    String formattedDateTime;

    {
        df.setTimeZone(ukTZ);
        formattedDateTime = df.format(dateObj);
    }

    public static void main(String[] args) {
    }
}