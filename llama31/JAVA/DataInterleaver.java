import java.util.stream.IntStream;

public class DataInterleaver {
    public static void main(String[] args) {
        int[][] data = generateTestData(200, 50);
        int[][] block1 = new int[data.length / 2][data[0].length / 2];
        int[][] block2 = new int[data.length / 2][data[0].length / 2];
        int[][] block3 = new int[data.length / 2][data[0].length / 2];
        int[][] block4 = new int[data.length / 2][data[0].length / 2];

        interleaveData(data, block1, block2, block3, block4);

        printBlock(block1, "Block 1");
        printBlock(block2, "Block 2");
        printBlock(block3, "Block 3");
        printBlock(block4, "Block 4");
    }

    public static void interleaveData(int[][] data, int[][] block1, int[][] block2, int[][] block3, int[][] block4) {
        Parallelizer parallelizer = new Parallelizer(data, block1, block2, block3, block4);
        parallelizer.run();
    }

    static class Parallelizer {
        private final int[][] data;
        private final int[][] block1;
        private final int[][] block2;
        private final int[][] block3;
        private final int[][] block4;

        public Parallelizer(int[][] data, int[][] block1, int[][] block2, int[][] block3, int[][] block4) {
            this.data = data;
            this.block1 = block1;
            this.block2 = block2;
            this.block3 = block3;
            this.block4 = block4;
        }

        public void run() {
            IntStream.range(0, data.length).parallel().forEach(this::interleaveRow);
        }

        private void interleaveRow(int rowIndex) {
            if (rowIndex % 2 == 0) {
                interleaveEvenRow(rowIndex);
            } else {
                interleaveOddRow(rowIndex);
            }
        }

        private void interleaveEvenRow(int rowIndex) {
            int blockRowIndex = rowIndex / 2;
            for (int colIndex = 0; colIndex < data[rowIndex].length; colIndex += 2) {
                block1[blockRowIndex][colIndex / 2] = data[rowIndex][colIndex];
                block2[blockRowIndex][colIndex / 2] = data[rowIndex][colIndex + 1];
            }
        }

        private void interleaveOddRow(int rowIndex) {
            int blockRowIndex = rowIndex / 2;
            for (int colIndex = 0; colIndex < data[rowIndex].length; colIndex += 2) {
                block3[blockRowIndex][colIndex / 2] = data[rowIndex][colIndex];
                block4[blockRowIndex][colIndex / 2] = data[rowIndex][colIndex + 1];
            }
        }
    }

    public static int[][] generateTestData(int rows, int cols) {
        int[][] data = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row][col] = row * cols + col + 1;
            }
        }
        return data;
    }

    public static void printBlock(int[][] block, String blockName) {
        System.out.println(blockName);
        for (int[] row : block) {
            for (int value : row) {
                System.out.printf("%04d ", value);
            }
            System.out.println();
        }
        System.out.println();
    }
}