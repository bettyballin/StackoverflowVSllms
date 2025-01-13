/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class SecureKeyGeneration {
    public static void main(String[] stringArray) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[32];
        secureRandom.nextBytes(byArray);
    }
}
