import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static void main(String[] args) {
        String longTimestamp = "2023-10-05 15:30:00"; // Example timestamp

        DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(longTimestamp, parseFormatter);

        DateTimeFormatter formatFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = date.format(formatFormatter);

        System.out.println(formattedDate);
    }
}