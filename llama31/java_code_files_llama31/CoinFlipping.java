/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CoinFlipping {
    static final int SIZE = 4;
    static boolean[][] grid = new boolean[4][4];

    public static void main(String[] stringArray) {
        CoinFlipping.grid[0][1] = false;
        CoinFlipping.grid[1][1] = false;
        CoinFlipping.grid[2][2] = false;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (!grid[i][j]) continue;
                CoinFlipping.grid[i][j] = true;
            }
        }
        LinkedList<FlipSequence> linkedList = new LinkedList<FlipSequence>();
        linkedList.add(new FlipSequence());
        while (!linkedList.isEmpty()) {
            FlipSequence flipSequence = (FlipSequence)linkedList.poll();
            if (CoinFlipping.isSolved()) {
                System.out.println("Solved in " + flipSequence.length() + " flips");
                return;
            }
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    if (grid[i][j]) continue;
                    FlipSequence flipSequence2 = flipSequence.append(new Flip(i, j));
                    linkedList.add(flipSequence2);
                    CoinFlipping.flip(i, j);
                }
            }
        }
    }

    static void flip(int n, int n2) {
        for (int i = Math.max(0, n - 1); i <= Math.min(3, n + 1); ++i) {
            for (int j = Math.max(0, n2 - 1); j <= Math.min(3, n2 + 1); ++j) {
                CoinFlipping.grid[i][j] = !grid[i][j];
            }
        }
    }

    static boolean isSolved() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (grid[i][j]) continue;
                return false;
            }
        }
        return true;
    }

    static class FlipSequence {
        List<Flip> flips = new ArrayList<Flip>();

        FlipSequence() {
        }

        public FlipSequence append(Flip flip) {
            FlipSequence flipSequence = new FlipSequence();
            flipSequence.flips.addAll(this.flips);
            flipSequence.flips.add(flip);
            return flipSequence;
        }

        public int length() {
            return this.flips.size();
        }
    }

    static class Flip {
        int row;
        int col;

        public Flip(int n, int n2) {
            this.row = n;
            this.col = n2;
        }
    }
}
