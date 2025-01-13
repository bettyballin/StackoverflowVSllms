/*
 * Decompiled with CFR 0.152.
 */
public class ArrayProcessor {
    public void processLargeArray(int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = this.performOperation(nArray[i]);
        }
    }

    public int performOperation(int n) {
        return n;
    }

    public static void main(String[] stringArray) {
        ArrayProcessor arrayProcessor = new ArrayProcessor();
        int[] nArray = new int[]{1, 2, 3, 4, 5};
        arrayProcessor.processLargeArray(nArray);
        for (int n : nArray) {
            System.out.println(n);
        }
    }
}
