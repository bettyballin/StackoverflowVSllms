/*
 * Decompiled with CFR 0.152.
 */
public class PercentageCalculator {
    public static void main(String[] stringArray) {
        long l = 4084094L;
        long l2 = 4081313L;
        double d = (1.0 - (double)l2 / (double)l) * 100.0;
        System.out.printf("%.4f%%%n", d);
    }
}
