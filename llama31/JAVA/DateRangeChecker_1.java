import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateRangeChecker_1 {
    public static void main(String[] args) {
        // Define a date range with midnight-to-midnight timestamps
        LocalDate startDate = LocalDate.of(2022, 9, 29);
        LocalDate endDate = LocalDate.of(2022, 10, 1);
        LocalDateTime startTimestamp = startDate.atStartOfDay();
        LocalDateTime endTimestamp = endDate.atStartOfDay();

        // Compare the current timestamp to the date range
        LocalDateTime now = LocalDateTime.now();
        if (startTimestamp.isBefore(now) && endTimestamp.isAfter(now)) {
            System.out.println("Current timestamp is within the date range");
        }
    }
}