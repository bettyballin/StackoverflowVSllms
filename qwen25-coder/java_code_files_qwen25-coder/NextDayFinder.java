import java.lang.String;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class NextDayFinder {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        
        // Test for each day of the week
        for (int i = 1; i <= 7; i++) {
            DayOfWeek targetDay = DayOfWeek.of(i);
            LocalDate nextDay = getNextOrSameWeekday(today, targetDay);
            System.out.println("Next " + targetDay + ": " + nextDay);
        }
    }

    public static LocalDate getNextOrSameWeekday(LocalDate date, DayOfWeek dayOfWeek) {
        LocalDate dateWithTargetDay = date.with(TemporalAdjusters.next(dayOfWeek));
        
        // If the found date is today or in future week, return it
        if (date.getDayOfWeek().getValue() <= dayOfWeek.getValue()) {
            return dateWithTargetDay;
        }
        
        // Otherwise, return next week's target day
        return dateWithTargetDay.plusWeeks(1);
    }
}