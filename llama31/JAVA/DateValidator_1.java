import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator_1 {
    public static boolean isValidDate(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Make sure to set lenient to false
        try {
            Date date = sdf.parse(String.format("%04d-%02d-%02d", year, month, day));
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidDate(2008, 2, 31)); // false
        System.out.println(isValidDate(2008, 2, 29)); // true
    }
}