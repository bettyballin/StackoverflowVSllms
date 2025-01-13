/*
 * Decompiled with CFR 0.152.
 */
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main_192 {
    public static void main(String[] stringArray) {
        Instant instant = Instant.now();
        String string = DateTimeFormatter.ISO_INSTANT.format(instant);
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        String string2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(zonedDateTime);
        System.out.println("UTC: " + string);
        System.out.println("Client's time zone: " + string2);
    }
}
