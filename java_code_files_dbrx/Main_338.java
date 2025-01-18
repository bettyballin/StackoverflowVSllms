import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2009, 5, 11); // Set the date (Note that month is zero-based!)
        Date targetDate = calendar.getTime();
        Timestamp tStartOfDay = new Timestamp(targetDate.getTime());
        Timestamp tEndOfDay = new Timestamp(targetDate.getTime() + 24*60*60*1000); // Add a day to the end of day
    }
}