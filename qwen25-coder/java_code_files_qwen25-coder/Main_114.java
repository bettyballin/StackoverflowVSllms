import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        Date myDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss.SSS zzz yyyy", Locale.ENGLISH).parse("Mon Jun 04 07:05:00.000 EDT 2007");
        SimpleDateFormat fmt2 = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.SSS");
        System.out.println(fmt2.format(myDate));  //Mon Jun 04 07:05:00.000 EDT 2007
    }
}