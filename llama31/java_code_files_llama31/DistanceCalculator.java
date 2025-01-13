/*
 * Decompiled with CFR 0.152.
 */
import java.util.stream.IntStream;

public class DistanceCalculator {
    public static void main(String[] stringArray) {
        DistanceCalculator distanceCalculator = new DistanceCalculator();
    }

    public int calculateDistance() {
        int n = 10;
        int[][] nArray = new int[10][10];
        int[] nArray2 = new int[10];
        int[] nArray3 = new int[10];
        int n3 = IntStream.range(1, n).map(n2 -> nArray[n2][n] + this.dist(nArray2[n2], nArray3[n2])).min().getAsInt();
        return n3;
    }

    public int dist(int n, int n2) {
        return 0;
    }
}
