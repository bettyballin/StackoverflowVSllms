/*
 * Decompiled with CFR 0.152.
 */
public class LeadersOfArray {
    public static void findLeaders(int[] nArray) {
        int n = nArray.length;
        int n2 = nArray[n - 1];
        System.out.print(n2 + " ");
        for (int i = n - 2; i >= 0; --i) {
            if (nArray[i] < n2) continue;
            n2 = nArray[i];
            System.out.print(n2 + " ");
        }
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{10, 9, 8, 6};
        LeadersOfArray.findLeaders(nArray);
    }
}
