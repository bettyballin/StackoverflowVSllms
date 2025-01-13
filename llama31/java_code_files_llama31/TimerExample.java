/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.TimeUnit;

public class TimerExample {
    public static void main(String[] stringArray) {
        long l = System.nanoTime();
        long l2 = System.nanoTime();
        long l3 = l2 - l;
        System.out.println("Duration: " + TimeUnit.NANOSECONDS.toMillis(l3) + " ms");
    }
}
