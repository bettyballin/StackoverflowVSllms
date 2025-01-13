/*
 * Decompiled with CFR 0.152.
 */
import java.util.stream.IntStream;

public class DataInterleaver {
    public static void main(String[] stringArray) {
        int[][] nArray = DataInterleaver.generateTestData(200, 50);
        int[][] nArray2 = new int[nArray.length / 2][nArray[0].length / 2];
        int[][] nArray3 = new int[nArray.length / 2][nArray[0].length / 2];
        int[][] nArray4 = new int[nArray.length / 2][nArray[0].length / 2];
        int[][] nArray5 = new int[nArray.length / 2][nArray[0].length / 2];
        DataInterleaver.interleaveData(nArray, nArray2, nArray3, nArray4, nArray5);
        DataInterleaver.printBlock(nArray2, "Block 1");
        DataInterleaver.printBlock(nArray3, "Block 2");
        DataInterleaver.printBlock(nArray4, "Block 3");
        DataInterleaver.printBlock(nArray5, "Block 4");
    }

    public static void interleaveData(int[][] nArray, int[][] nArray2, int[][] nArray3, int[][] nArray4, int[][] nArray5) {
        Parallelizer parallelizer = new Parallelizer(nArray, nArray2, nArray3, nArray4, nArray5);
        parallelizer.run();
    }

    public static int[][] generateTestData(int n, int n2) {
        int[][] nArray = new int[n][n2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                nArray[i][j] = i * n2 + j + 1;
            }
        }
        return nArray;
    }

    public static void printBlock(int[][] nArray, String string) {
        System.out.println(string);
        int[][] nArray2 = nArray;
        int n = nArray2.length;
        for (int i = 0; i < n; ++i) {
            int[] nArray3;
            for (int n2 : nArray3 = nArray2[i]) {
                System.out.printf("%04d ", n2);
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Parallelizer {
        private final int[][] data;
        private final int[][] block1;
        private final int[][] block2;
        private final int[][] block3;
        private final int[][] block4;

        public Parallelizer(int[][] nArray, int[][] nArray2, int[][] nArray3, int[][] nArray4, int[][] nArray5) {
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
}
