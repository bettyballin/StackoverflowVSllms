/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class RandomGenerator {
    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

    public static void main(String[] stringArray) throws Exception {
        new RandomGenerator();
    }
}
