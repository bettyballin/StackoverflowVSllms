import java.lang.String;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateHelper {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date myDate = new Date();
    String dateStr = sdf.format(myDate);
    StringBuilder sb = new StringBuilder();

    {
        sb.append(", '" + dateStr + "' ");
    }

    public static void main(String[] args) {
    }
}