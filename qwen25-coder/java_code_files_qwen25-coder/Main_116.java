import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        String date = "06-04-2007 07:05";
        SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        Date myDate = fmt.parse(date); 
        System.out.println(myDate);  //Mon Jun 04 07:05:00 EDT 2007
        long timestamp = myDate.getTime();
        System.out.println(timestamp); //1180955100000
    }
}