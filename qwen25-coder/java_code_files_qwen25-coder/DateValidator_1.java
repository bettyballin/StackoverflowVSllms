import java.lang.String;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.DateTimeException;

public class DateValidator_1 {
    public static boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidDate(2008, 2, 31)); // Should print: false
        System.out.println(isValidDate(2008, 2, 29)); // Should print: true (leap year)
    }
}