/*
 * Decompiled with CFR 0.152.
 */
public class PriorityQueue {
    private int[] priorities;

    public void insert(int n, Object object) {
        int n2 = this.findIndex(n);
    }

    private int findIndex(int n) {
        for (int i = 0; i < this.priorities.length; ++i) {
            if (n >= this.priorities[i]) continue;
            return i;
        }
        return this.priorities.length;
    }

    public static void main(String[] stringArray) {
    }
}
