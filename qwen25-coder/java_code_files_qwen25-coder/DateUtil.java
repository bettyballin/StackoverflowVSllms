import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {

   public static String formatDate(Date date, String pattern) {
       if (date == null || pattern == null) return "";
       SimpleDateFormat sdf = new SimpleDateFormat(pattern);
       return sdf.format(date);
   }

   public static void main(String[] args) {
   }
}