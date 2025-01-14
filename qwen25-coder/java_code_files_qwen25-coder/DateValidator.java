import java.lang.String;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {
    public static boolean isValidDate(String dateStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(dateStr, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String dateStr = "2008-06-31"; // Example invalid date
        if (isValidDate(dateStr)) {
            System.out.println("The date is valid.");
        } else {
            System.out.println("The date is invalid.");
        }
    }
}