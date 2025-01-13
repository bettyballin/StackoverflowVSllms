/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class WeightedRandomQueueSelector {
    private Random random = new Random();
    private int[] weights;
    private int totalWeight;

    public WeightedRandomQueueSelector(int[] nArray) {
        this.weights = new int[nArray.length];
        this.totalWeight = 0;
        for (int i = 0; i < nArray.length; ++i) {
            this.weights[i] = nArray[i];
            this.totalWeight += this.weights[i];
        }
    }

    public int selectQueue() {
        int n = this.random.nextInt(this.totalWeight);
        int n2 = 0;
        for (int i = 0; i < this.weights.length; ++i) {
            if (n >= (n2 += this.weights[i])) continue;
            return i;
        }
        return this.weights.length - 1;
    }

    public static void main(String[] stringArray) {
    }
}
