/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.UUID;

public class SecureGUIDGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static UUID generateGUID() {
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        return UUID.nameUUIDFromBytes(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
