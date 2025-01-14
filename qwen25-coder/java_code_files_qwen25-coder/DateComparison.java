import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Calendar;

public class DateComparison {
    public static void main(String[] args) {
        // Assuming date1 and date2 are your Date objects
        // Create sample Date objects
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2023, Calendar.OCTOBER, 20); // October 20, 2023
        java.util.Date utilDate1 = cal1.getTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.set(2023, Calendar.OCTOBER, 21); // October 21, 2023
        java.util.Date utilDate2 = cal2.getTime();

        // Convert them to LocalDate by specifying the ZoneId (e.g., systemDefault)
        LocalDate localDate1 = utilDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = utilDate2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Compare only the dates
        boolean isSameDay = localDate1.isEqual(localDate2);
        
        System.out.println("Are the dates the same day? " + isSameDay);
    }
}