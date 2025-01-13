/*
 * Decompiled with CFR 0.152.
 */
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main_383 {
    public static void main(String[] stringArray) {
        LocalDate localDate = LocalDate.of(2007, 9, 23);
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        System.out.println(instant);
    }
}
