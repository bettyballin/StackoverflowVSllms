/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class Main_602 {
    public static void main(String[] stringArray) {
        long l = 1234567890L;
        Random random = new Random(l);
        Random random2 = new Random(l);
        for (int i = 0; i < 10; ++i) {
            System.out.println("PRNG1: " + random.nextInt(100) + " PRNG2: " + random2.nextInt(100));
        }
    }
}
