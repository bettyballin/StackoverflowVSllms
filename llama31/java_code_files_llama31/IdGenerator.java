/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.UUID;

public class IdGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static UUID generateId() {
        return UUID.randomUUID();
    }

    public static void main(String[] stringArray) {
        UUID uUID = IdGenerator.generateId();
        System.out.println("Generated ID: " + String.valueOf(uUID));
    }
}
