/*
 * Decompiled with CFR 0.152.
 */
import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneUtil {
    public static void main(String[] stringArray) {
        TimeZone timeZone = TimeZone.getTimeZone("Japan");
        String string = timeZone.getDisplayName(Locale.US);
        System.out.println(string);
    }
}
