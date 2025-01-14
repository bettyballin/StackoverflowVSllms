import java.lang.String;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class FourthSaturday {
    public static void main(String[] args) {
        LocalDate fourthSaturday = getFourthSaturdayOfMonth(LocalDate.now());
        System.out.println("The fourth Saturday of the month is: " + fourthSaturday);
    }

    public static LocalDate getFourthSaturdayOfMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.from(date);
        LocalDate firstDayOfMonth = yearMonth.atDay(1);

        int offsetToFirstSaturday = DayOfWeek.SATURDAY.getValue() - firstDayOfMonth.getDayOfWeek().getValue();
        if (offsetToFirstSaturday < 0) {
            offsetToFirstSaturday += 7;
        }
        
        // Calculate the fourth Saturday
        LocalDate fourthSaturday = firstDayOfMonth.plusDays(offsetToFirstSaturday + (3 * 7));
        return fourthSaturday;
    }
}