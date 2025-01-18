import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class FuzzyDateCalculator {
    // Initialize object and calculate date in main method
    public static void main(String[] args) {
        FuzzyDateCalculator fdcr = new FuzzyDateCalculator(); // Initialize object
        System.out.println(fdcr.calculate(LocalDateTime.now().minusDays(2))); // Output: last weekday like Tuesday, Sunday, etc.
    }

    public String calculate(LocalDateTime dateTime) {
        // Return the name of the day of the week for the given date
        return dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}