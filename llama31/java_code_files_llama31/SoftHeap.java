/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class SoftHeap {
    private int[] heap;
    private int size;
    private int errorRate;

    public SoftHeap(int n, int n2) {
        this.heap = new int[n];
        this.size = 0;
        this.errorRate = n2;
    }

    public void insert(int n) {
        if (this.size < this.heap.length) {
            this.heap[this.size++] = n;
        } else if (Math.random() < (double)this.errorRate) {
            this.heap[0] = n;
        }
    }

    public int[] getSortedArray() {
        Arrays.sort(this.heap, 0, this.size);
        return Arrays.copyOfRange(this.heap, 0, this.size);
    }

    public static void main(String[] stringArray) {
    }
}
