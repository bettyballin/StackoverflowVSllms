import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateExample {
    public static void main(String[] args) throws Exception {
        String date = "06-04-2007 07:05";
        SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        fmt.setTimeZone(TimeZone.getTimeZone("EDT")); // Timezone can be set explicitly to match the string's timezone information if necessary before parsing date from String
        Date myDate = fmt.parse(date);
        System.out.println(myDate); // Mon Jun 04 07:05:00 EDT 2007

        long timestamp;
        timestamp = myDate.getTime();
        System.out.println(timestamp); // 1180955100000 - Still no trailing digits because Date is parsed from a String with hour and minutes detail not milliseconds

        // on the other hand...
        myDate = new Date(); // New date object based on current time (which inherently includes millisecond level information)
        System.out.println(myDate);  // e.g., Tue Sep 16 13:02:44 EDT 2008

        timestamp = myDate.getTime();
        System.out.println(timestamp); // e.g., 1221584564748 - Trailing digits since Date was created based on current time with millisecond level information
    }
}