/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;
import java.util.TimeZone;

public class GetCurrentDateInUTC {
    public static void main(String[] stringArray) {
        Date date = new Date();
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        date.setTime(date.getTime() + (long)timeZone.getOffset(date.getTime()));
        System.out.println("Current date in UTC: " + String.valueOf(date));
    }
}
