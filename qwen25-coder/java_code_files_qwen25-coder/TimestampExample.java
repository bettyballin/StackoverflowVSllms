import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;

public class TimestampExample {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = dateFormat.parse("23/09/2007");
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}