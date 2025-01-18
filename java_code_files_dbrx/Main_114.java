import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String timestampFormat = LocalDateTime.now().format(formatter);
        System.out.println(timestampFormat);  // Prints e.g.: "2023-03-16 11:47:55.821"
    }
}