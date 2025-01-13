/*
 * Decompiled with CFR 0.152.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateRangeChecker_1 {
    public static void main(String[] stringArray) {
        LocalDate localDate = LocalDate.of(2022, 9, 29);
        LocalDate localDate2 = LocalDate.of(2022, 10, 1);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        LocalDateTime localDateTime2 = localDate2.atStartOfDay();
        LocalDateTime localDateTime3 = LocalDateTime.now();
        if (localDateTime.isBefore(localDateTime3) && localDateTime2.isAfter(localDateTime3)) {
            System.out.println("Current timestamp is within the date range");
        }
    }
}
