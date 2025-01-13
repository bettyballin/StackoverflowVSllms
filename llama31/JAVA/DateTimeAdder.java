import java.lang.Integer;
import java.lang.String;
public class DateTimeAdder {
    public static String addTime(String datetime, String add) {
        String[] datetimeParts = datetime.split(":");
        int hours = Integer.parseInt(datetimeParts[0]);
        int minutes = Integer.parseInt(datetimeParts[1]);
        int seconds = datetimeParts.length > 2 ? Integer.parseInt(datetimeParts[2]) : 0;

        String[] addParts = add.split(":");
        int addHours = Integer.parseInt(addParts[0]);
        int addMinutes = Integer.parseInt(addParts[1]);
        int addSeconds = Integer.parseInt(addParts[2]);

        seconds += addSeconds;
        minutes += addMinutes + (seconds / 60);
        hours += addHours + (minutes / 60);

        seconds %= 60;
        minutes %= 60;
        hours %= 24;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        System.out.println(addTime("13:30", "02:02:02"));  // Output: 15:32:02
        System.out.println(addTime("13:30", "00:00:01"));  // Output: 13:30:01
        System.out.println(addTime("13:30", "00:01:00"));  // Output: 13:31:00
    }
}