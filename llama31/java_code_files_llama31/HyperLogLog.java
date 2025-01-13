/*
 * Decompiled with CFR 0.152.
 */
public class HyperLogLog {
    private int p;
    private int m;
    private int[] M;

    public HyperLogLog(int n, int n2) {
        this.p = n;
        this.m = n2;
        this.M = new int[n2];
    }

    public void add(long l) {
        int n = (int)(l % (long)this.m);
        int n2 = (int)(l / (long)this.m);
        this.M[n] = Math.max(this.M[n], Integer.numberOfTrailingZeros(n2));
    }

    public double estimate() {
        double d = 0.0;
        for (int i = 0; i < this.m; ++i) {
            d += Math.pow(2.0, -this.M[i]);
        }
        return Math.pow(2.0, this.p) * (1.0 / d);
    }

    public static void main(String[] stringArray) {
    }
}
