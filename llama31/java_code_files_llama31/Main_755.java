/*
 * Decompiled with CFR 0.152.
 */
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main_755 {
    public static void main(String[] stringArray) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String string = zonedDateTime.format(dateTimeFormatter);
        System.out.println(string);
    }
}
