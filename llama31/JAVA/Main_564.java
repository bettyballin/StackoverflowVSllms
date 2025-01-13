import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main_564 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDateTime midnight = date.atStartOfDay();

        System.out.println(midnight);
    }
}