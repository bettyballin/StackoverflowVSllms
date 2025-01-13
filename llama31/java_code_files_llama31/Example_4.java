/*
 * Decompiled with CFR 0.152.
 */
public class Example_4 {
    public static void main(String[] stringArray) {
        int[] nArray = new int[1000000];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = i;
        }
        int[] nArray2 = new int[1000000];
        for (int i = 0; i < nArray2.length; ++i) {
            nArray2[i] = i * 2;
        }
    }
}
