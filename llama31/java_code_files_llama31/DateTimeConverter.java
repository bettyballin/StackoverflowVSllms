/*
 * Decompiled with CFR 0.152.
 */
import java.time.Instant;
import java.util.Date;

public class DateTimeConverter {
    public static void main(String[] stringArray) {
        Instant instant = Instant.now();
        Date date = Date.from(instant);
    }
}
