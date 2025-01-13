import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class DateValidator_3 {

    public static boolean isValidDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false); // This will make the parser strict
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String dateStr = "2008-06-31"; // Invalid date
        String format = "yyyy-MM-dd";
        if (isValidDate(dateStr, format)) {
            Timestamp expiryDate = Timestamp.valueOf(dateStr + " " + "23:59:59.000");
            System.out.println(expiryDate);
        } else {
            System.out.println("Invalid date");
        }
    }
}