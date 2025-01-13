/*
 * Decompiled with CFR 0.152.
 */
import java.time.Instant;
import java.util.UUID;

public class UniqueFileNameGenerator {
    public static String generateUniqueFileName() {
        Instant instant = Instant.now();
        UUID uUID = UUID.randomUUID();
        String string = instant.toEpochMilli() + "-" + uUID.toString();
        return string;
    }

    public static void main(String[] stringArray) {
    }
}
