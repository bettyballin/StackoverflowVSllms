import java.util.Calendar;
import java.util.Date;

public class DateComparator {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date();

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);

        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);

        if (cal1.equals(cal2)) {
            System.out.println("Same day");
        } else {
            System.out.println("Different day");
        }
    }
}