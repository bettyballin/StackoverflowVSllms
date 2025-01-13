/*
 * Decompiled with CFR 0.152.
 */
public class PricingCalculator {
    public int getPrice(int n, int n2, int n3, int n4) {
        int n5 = 0;
        if (n4 > 18) {
            n5 += this.calculateDiscount(5, n);
        }
        if (n2 > 10) {
            n5 += this.calculateDiscount(5, n);
        }
        if (n3 > 60 || n3 < 18) {
            n5 += this.calculateDiscount(5, n);
        }
        return n - n5;
    }

    private int calculateDiscount(int n, int n2) {
        return (int)((double)n2 * ((double)n / 100.0));
    }

    public static void main(String[] stringArray) {
    }
}
