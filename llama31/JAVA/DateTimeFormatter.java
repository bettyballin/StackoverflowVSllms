import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateTimeFormatter {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    {
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
    }

    public static void main(String[] args) {
    }
}