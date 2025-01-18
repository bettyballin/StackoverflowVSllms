import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;

public class Main_6 {
    public static void main(String[] args) {
        String dateStr = "2015-14-39"; // sample invalid date string input
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
        try {
            Date dt = sdf.parse(dateStr);
            Timestamp expiryDate = new Timestamp(dt.getTime());
            System.out.println("The valid date is: " + expiryDate);  // only printed if the input string represents a valid date
        } catch (ParseException e) {
            System.err.println("Invalid date format.");
        }
    }
}