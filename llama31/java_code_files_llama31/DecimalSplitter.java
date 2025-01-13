/*
 * Decompiled with CFR 0.152.
 */
public class DecimalSplitter {
    public static void main(String[] stringArray) {
        double d = 3.25;
        int n = (int)d;
        double d2 = d - (double)n;
        System.out.println("Whole: " + n);
        System.out.println("Fractional: " + d2);
    }
}
