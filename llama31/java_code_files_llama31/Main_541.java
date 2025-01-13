/*
 * Decompiled with CFR 0.152.
 */
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main_541 {
    public static void main(String[] stringArray) {
        LocalDate localDate = LocalDate.of(2022, 12, 31);
        Instant instant = localDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
        long l = instant.toEpochMilli();
        System.out.println(l);
    }
}
