import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRangeFormatter {
    SimpleDateFormat fmt = new SimpleDateFormat("MM/dd");
    Date start;
    Date end;
    String strStart = fmt.format(start); // Display as calendar date
    String strEnd   = fmt.format(end);
    public static void main(String[] args) {
    }
}