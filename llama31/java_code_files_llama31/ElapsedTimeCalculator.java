/*
 * Decompiled with CFR 0.152.
 */
public class ElapsedTimeCalculator {
    public static void main(String[] stringArray) {
        long l = System.currentTimeMillis();
        long l2 = System.currentTimeMillis();
        long l3 = l2 - l;
        System.out.println("Elapsed time: " + l3 + " milliseconds");
    }
}
