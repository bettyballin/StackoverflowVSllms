import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatHelper {
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