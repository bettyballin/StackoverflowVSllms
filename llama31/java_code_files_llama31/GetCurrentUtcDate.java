/*
 * Decompiled with CFR 0.152.
 */
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class GetCurrentUtcDate {
    public static void main(String[] stringArray) {
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));
        System.out.println("Current UTC Date: " + String.valueOf(zonedDateTime));
    }
}
