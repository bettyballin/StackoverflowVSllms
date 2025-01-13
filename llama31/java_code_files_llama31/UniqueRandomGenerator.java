/*
 * Decompiled with CFR 0.152.
 */
class UniqueRandomGenerator {
    private int[] array;
    private int index;

    public UniqueRandomGenerator(int n) {
        this.array = new int[n];
        for (int i = 0; i < n; ++i) {
            this.array[i] = i;
        }
        this.shuffle(this.array);
    }

    public int next() {
        return this.array[this.index++];
    }

    private void shuffle(int[] nArray) {
        for (int i = nArray.length - 1; i > 0; --i) {
            int n = (int)(Math.random() * (double)(i + 1));
            int n2 = nArray[n];
            nArray[n] = nArray[i];
            nArray[i] = n2;
        }
    }
}
