/*
 * Decompiled with CFR 0.152.
 */
import java.util.Calendar;
import java.util.Date;

public class AgeCalculator {
    public static int calculateAge(Date date) {
        int n = 0;
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            n = calendar.get(2) >= calendar2.get(2) && calendar.get(5) >= calendar2.get(5) ? calendar.get(1) - calendar2.get(1) : calendar.get(1) - calendar2.get(1) - 1;
        }
        return n;
    }

    public static void main(String[] stringArray) {
        Date date = new Date(100, 0, 1);
        int n = AgeCalculator.calculateAge(date);
        System.out.println("Age: " + n);
    }
}
