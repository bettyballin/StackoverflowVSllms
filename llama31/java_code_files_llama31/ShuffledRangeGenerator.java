/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class ShuffledRangeGenerator {
    private int[] range;
    private int index;

    public ShuffledRangeGenerator(int n, int n2) {
        this.range = new int[n2];
        for (int i = 0; i < n2; ++i) {
            this.range[i] = i;
        }
        this.shuffle(this.range, new Random(n));
        this.index = 0;
    }

    public int next() {
        return this.range[this.index++];
    }

    private void shuffle(int[] nArray, Random random) {
        for (int i = nArray.length - 1; i > 0; --i) {
            int n = random.nextInt(i + 1);
            int n2 = nArray[i];
            nArray[i] = nArray[n];
            nArray[n] = n2;
        }
    }

    public static void main(String[] stringArray) {
        ShuffledRangeGenerator shuffledRangeGenerator = new ShuffledRangeGenerator(42, 1000000);
        for (int i = 0; i < 1000000; ++i) {
            System.out.println(shuffledRangeGenerator.next());
        }
    }
}
