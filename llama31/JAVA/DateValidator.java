import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator {
    public boolean isDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DateValidator validator = new DateValidator();
        System.out.println(validator.isDate("2022-01-01 12:00:00")); // prints: true
        System.out.println(validator.isDate("invalid date")); // prints: false
    }
}