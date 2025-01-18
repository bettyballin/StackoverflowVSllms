import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main_4 {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date currentTime = new Date();
        // Assign the date value to your object
        calendar.setTime(currentTime);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        // Reset hour, minute and second to 0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date midnightTime = calendar.getTime();

        // Print initial time
        System.out.println("Initial Time : " + sdf.format(currentTime));
        // Print reseted mid-night hour of the same day
        System.out.println("Mid-night Time: " + sdf.format(midnightTime));
    }
}