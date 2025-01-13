import java.text.SimpleDateFormat;
import java.util.Date;

public class UnixTimestampConverter {
    public static void main(String[] args) {
        long unixTimestamp = 1251783433;
        Date date = new Date(unixTimestamp * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        System.out.println(formattedDate);
    }
}