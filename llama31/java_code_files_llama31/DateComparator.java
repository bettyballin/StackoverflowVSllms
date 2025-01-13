/*
 * Decompiled with CFR 0.152.
 */
import java.util.Calendar;
import java.util.Date;

public class DateComparator {
    public static void main(String[] stringArray) {
        Date date = new Date();
        Date date2 = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        if (calendar.equals(calendar2)) {
            System.out.println("Same day");
        } else {
            System.out.println("Different day");
        }
    }
}
