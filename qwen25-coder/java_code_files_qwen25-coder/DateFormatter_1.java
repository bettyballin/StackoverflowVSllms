import java.lang.String;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class DateFormatter_1 {
    public static void main(String[] args) {
        int year = 2023;
        int month = 9; // Note: Months are zero-based (0=January)
        int day = 15;
        int hour = 14; // 24-hour format
        int minute = 30;

        Date date = new Date(year - 1900, month - 1, day, hour, minute);
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.getDefault());
        String formattedDate = formatter.format(date);

        System.out.println("Formatted Date and Time: " + formattedDate);
    }
}