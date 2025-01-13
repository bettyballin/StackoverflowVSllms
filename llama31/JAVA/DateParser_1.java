import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser_1_1 {
    public static void main(String[] args) throws ParseException {
        String date = "06-04-2007 07:05:00.000";
        SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.SSS");
        Date myDate = fmt.parse(date);
    }
}