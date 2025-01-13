/*
 * Decompiled with CFR 0.152.
 */
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateTimeFormatter {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

    public DateTimeFormatter() {
        this.sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
    }

    public static void main(String[] stringArray) {
    }
}
