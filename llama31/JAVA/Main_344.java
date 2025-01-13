import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main_344 {
    public static void main(String[] args) {
        // assuming 'dateString' is your UTC date string in the format 'YYYY-MM-DD HH:MM:SS'
        String dateString = "2022-01-01 12:00:00";

        // convert date string to LocalDateTime object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateObject = LocalDateTime.parse(dateString, formatter);

        // convert LocalDateTime object to unix timestamp
        long unixTimestamp = dateObject.atZone(ZoneId.of("UTC")).toInstant().getEpochSecond();

        System.out.println(unixTimestamp);
    }
}