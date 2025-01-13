/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class UniqueIdGenerator {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] stringArray) {
        System.out.println(UniqueIdGenerator.generateId());
    }
}
