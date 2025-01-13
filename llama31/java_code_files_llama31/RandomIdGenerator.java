/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class RandomIdGenerator {
    public static void main(String[] stringArray) {
        SecureRandom secureRandom = new SecureRandom();
        long l = secureRandom.nextLong();
        System.out.println(l);
    }
}
