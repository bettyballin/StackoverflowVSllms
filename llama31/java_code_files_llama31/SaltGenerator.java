/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class SaltGenerator {
    public static byte[] generateSalt(int n) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[n];
        secureRandom.nextBytes(byArray);
        return byArray;
    }

    public static void main(String[] stringArray) {
    }
}
