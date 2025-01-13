/*
 * Decompiled with CFR 0.152.
 */
public class MajorityElement {
    public static int majorityElement(int[] nArray) {
        int n = 0;
        int n2 = 0;
        for (int n3 : nArray) {
            if (n == 0) {
                n2 = n3;
                n = 1;
                continue;
            }
            n += n3 == n2 ? 1 : -1;
        }
        return n2;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{3, 2, 3, 4, 3, 4, 5, 3, 3};
        System.out.println("Majority element is " + MajorityElement.majorityElement(nArray));
    }
}
