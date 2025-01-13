/*
 * Decompiled with CFR 0.152.
 */
public class BinaryIndexedTree {
    private int[] bit;

    public BinaryIndexedTree(int n) {
        this.bit = new int[n + 1];
    }

    public void insert(int n, int n2) {
        while (n < this.bit.length) {
            int n3 = n;
            this.bit[n3] = this.bit[n3] + n2;
            n += n & -n;
        }
    }

    public void remove(int n, int n2) {
        while (n < this.bit.length) {
            int n3 = n;
            this.bit[n3] = this.bit[n3] - n2;
            n += n & -n;
        }
    }

    public int getCumulativeSum(int n) {
        int n2 = 0;
        while (n > 0) {
            n2 += this.bit[n];
            n -= n & -n;
        }
        return n2;
    }

    public static void main(String[] stringArray) {
    }
}
