/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class Main_92 {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{10, 20, 30, 40, 50};
        BKTree bKTree = new BKTree(nArray);
        int n = 35;
        int n2 = 6;
        List<int[]> list = bKTree.search(n, n2);
        for (int[] nArray2 : list) {
            System.out.println("Key: " + nArray2[0] + ", Distance: " + nArray2[1]);
        }
    }
}
