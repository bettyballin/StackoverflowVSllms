import java.time.*;
import java.time.format.*;

public class Main
{
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();  // get the current date and time with zone
        String formatted = DateTimeFormatter.ofPattern("h:mm a z").format(now);
        System.out.println(formatted);
    }
}