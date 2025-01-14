import java.lang.String;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ResetTimeToMidnight {
    public static void main(String[] args) {
        // Assuming you have a LocalDateTime object
        LocalDateTime originalDateTime = LocalDateTime.now();

        // Resetting time to midnight using LocalDate
        LocalDate datePart = originalDateTime.toLocalDate();
        LocalDateTime midnightDateTime = datePart.atStartOfDay();

        System.out.println("Original DateTime: " + originalDateTime);
        System.out.println("Midnight DateTime: " + midnightDateTime);

        // Alternatively, using withTime method
        LocalDateTime anotherMidnightDateTime = originalDateTime.with(LocalTime.MIDNIGHT);
        System.out.println("Another Midnight DateTime: " + anotherMidnightDateTime);
    }
}