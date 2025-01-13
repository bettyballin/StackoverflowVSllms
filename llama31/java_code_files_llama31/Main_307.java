/*
 * Decompiled with CFR 0.152.
 */
public class Main_307 {
    public static int findMajorityElement(int[] nArray) {
        int n = 0;
        int n2 = 0;
        for (int n3 : nArray) {
            if (n == 0) {
                n2 = n3;
                n = 1;
                continue;
            }
            if (n2 == n3) {
                ++n;
                continue;
            }
            --n;
        }
        return n2;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(Main_307.findMajorityElement(nArray));
    }
}
