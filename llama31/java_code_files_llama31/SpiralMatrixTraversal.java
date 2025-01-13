/*
 * Decompiled with CFR 0.152.
 */
public class SpiralMatrixTraversal {
    public static void traverse(int n, int n2) {
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 1;
        int[] nArray = new int[]{n, n2};
        for (int i = 0; i < n * n2; ++i) {
            System.out.println("(" + n3 + ", " + n4 + ")");
            if (n3 + n5 >= nArray[0] || n3 + n5 < -nArray[0] || n4 + n6 >= nArray[1] || n4 + n6 < -nArray[1]) {
                int n7 = n5;
                n5 = -n6;
                n6 = n7;
            }
            n3 += n5;
            n4 += n6;
        }
    }

    public static void main(String[] stringArray) {
        SpiralMatrixTraversal.traverse(3, 3);
        SpiralMatrixTraversal.traverse(5, 3);
    }
}
