import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimeFormatter_1 {

    int year = 2021;
    int month = 8;
    int day = 23;
    int hour = 14;
    int minute = 30;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    Calendar calendar = Calendar.getInstance();

    {
        calendar.set(year, month - 1, day, hour, minute); // months are zero-based so we need to subtract one from the provided month value
        String formattedDateAndTime = sdf.format(calendar.getTime());
        System.out.println(formattedDateAndTime);
    }

    public static void main(String[] args) {
        new DateTimeFormatter_1();
    }
}