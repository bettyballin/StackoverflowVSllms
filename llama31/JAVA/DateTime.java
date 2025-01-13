import java.util.Date;
import java.text.SimpleDateFormat;

public class DateTime {
    public static void main(String[] args) {
        // Get the current date and time from the server
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);

        // Display the date and time on the console
        System.out.println("Current Date and Time: " + formattedDate);
    }
}