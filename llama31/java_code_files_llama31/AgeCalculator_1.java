/*
 * Decompiled with CFR 0.152.
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeCalculator_1 {
    public static void main(String[] stringArray) {
        int n = 2008;
        int n2 = 1;
        int n3 = 1;
        AgeCalculator_1.calculateAge(n, n2, n3);
    }

    public static void calculateAge(int n, int n2, int n3) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(n, n2, n3);
        long l = ChronoUnit.YEARS.between(localDate2, localDate);
        long l2 = ChronoUnit.MONTHS.between(localDate2, localDate) % 12L;
        long l3 = ChronoUnit.DAYS.between(localDate2, localDate) % 30L;
        System.out.println(l + " years, " + l2 + " months, " + l3 + " days");
    }
}
