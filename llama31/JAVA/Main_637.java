import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main_637 {
    public static void main(String[] args) {
        // Assuming you have year, month, day, hour, and minute variables
        int year = 2023;
        int month = 0; // January is 0, February is 1, etc.
        int day = 1;
        int hour = 12;
        int minute = 30;

        // Create a Date object
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);
        Date date = calendar.getTime();

        // Format the date according to the device's locale
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        String formattedDate = dateFormat.format(date);

        // Use the formattedDate string as needed
        System.out.println(formattedDate);
    }
}