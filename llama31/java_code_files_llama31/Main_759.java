/*
 * Decompiled with CFR 0.152.
 */
public class Main_759 {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{4, 5, 5, 5, 7, 8, 9, 10, 10};
        int[] nArray2 = new int[]{3, 6, 11};
        int[] nArray3 = new int[]{5, 10};
        System.out.println("Array: ");
        for (int n : nArray) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Missed: ");
        for (int n : nArray2) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Duplicates: ");
        for (int n : nArray3) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
