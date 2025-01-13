/*
 * Decompiled with CFR 0.152.
 */
public class TimeCalculator {
    public static void main(String[] stringArray) {
        long l = System.currentTimeMillis();
        long l2 = System.currentTimeMillis();
        long l3 = (l2 - l) / 1000L;
        System.out.println("Time taken in seconds: " + l3);
    }
}
