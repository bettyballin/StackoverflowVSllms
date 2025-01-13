/*
 * Decompiled with CFR 0.152.
 */
import java.util.stream.IntStream;

static class DataInterleaver.Parallelizer {
    private final int[][] data;
    private final int[][] block1;
    private final int[][] block2;
    private final int[][] block3;
    private final int[][] block4;

    public DataInterleaver.Parallelizer(int[][] nArray, int[][] nArray2, int[][] nArray3, int[][] nArray4, int[][] nArray5) {
        this.data = nArray;
        this.block1 = nArray2;
        this.block2 = nArray3;
        this.block3 = nArray4;
        this.block4 = nArray5;
    }

    public void run() {
        IntStream.range(0, this.data.length).parallel().forEach(this::interleaveRow);
    }

    private void interleaveRow(int n) {
        if (n % 2 == 0) {
            this.interleaveEvenRow(n);
        } else {
            this.interleaveOddRow(n);
        }
    }

    private void interleaveEvenRow(int n) {
        int n2 = n / 2;
        for (int i = 0; i < this.data[n].length; i += 2) {
            this.block1[n2][i / 2] = this.data[n][i];
            this.block2[n2][i / 2] = this.data[n][i + 1];
        }
    }

    private void interleaveOddRow(int n) {
        int n2 = n / 2;
        for (int i = 0; i < this.data[n].length; i += 2) {
            this.block3[n2][i / 2] = this.data[n][i];
            this.block4[n2][i / 2] = this.data[n][i + 1];
        }
    }
}
