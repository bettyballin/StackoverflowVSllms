import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateComparator_1_1 {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date();

        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (localDate1.equals(localDate2)) {
            System.out.println("Same day");
        } else {
            System.out.println("Different day");
        }
    }
}