import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main_635 {
    public static void main(String[] args) {
        // Assuming you have year, month, day, hour, and minute variables
        int year = 2023;
        int month = 1; // January is 1, February is 2, etc.
        int day = 1;
        int hour = 12;
        int minute = 30;

        // Create a LocalDateTime object
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);

        // Format the date according to the device's locale
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = dateTime.format(formatter);

        // Use the formattedDate string as needed
        System.out.println(formattedDate);
    }
}