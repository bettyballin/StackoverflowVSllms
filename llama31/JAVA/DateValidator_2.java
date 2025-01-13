import java.time.LocalDate;
import java.time.DateTimeException;

public class DateValidator_2_2 {
    public static boolean isValidDate(int year, int month, int day) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidDate(2008, 2, 31)); // false
        System.out.println(isValidDate(2008, 2, 29)); // true
    }
}