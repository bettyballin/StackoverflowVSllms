import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class Main_73 {
    public static void main(String[] args) {
        long utcSeconds = 1643723400L; // your UTC timestamp in seconds

        // Convert to milliseconds
        long utcMillis = utcSeconds * 1000;

        // Create a Calendar object
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(utcMillis);

        // Set the time to the start of the day
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // Get the start of the day in milliseconds
        long startOfDayMillis = calendar.getTimeInMillis();

        // Group by start of day
        Map<Long, List<Long>> groupedDates = new HashMap<>();
        groupedDates.computeIfAbsent(startOfDayMillis, k -> new ArrayList<>()).add(utcSeconds);

        System.out.println(groupedDates);
    }
}