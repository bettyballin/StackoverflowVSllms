import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateParser_2_2 {
    public static void main(String[] args) throws ParseException {
        String date = "06-04-2007 07:05";
        SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        Calendar cal = Calendar.getInstance();
        cal.setTime(fmt.parse(date));
        cal.set(Calendar.MILLISECOND, 0); // or any other value
        Date myDate = cal.getTime();
        System.out.println(myDate);
    }
}