/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class Main_822 {
    public static void main(String[] stringArray) {
        SecureRandom secureRandom = new SecureRandom();
        String string = String.valueOf(secureRandom.nextLong());
        System.out.println(string);
    }
}
