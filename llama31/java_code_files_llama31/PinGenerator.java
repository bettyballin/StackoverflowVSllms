/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class PinGenerator {
    public static String generatePin(int n) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(secureRandom.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
