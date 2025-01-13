/*
 * Decompiled with CFR 0.152.
 */
public class IntegerArrayBenchmark {
    public static void main(String[] stringArray) {
        int[] nArray = new int[1000000];
        Integer[] integerArray = new Integer[1000000];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = i;
            integerArray[i] = i;
        }
        long l = System.nanoTime();
        int n = 0;
        for (int i = 0; i < nArray.length; ++i) {
            n += nArray[i];
        }
        long l2 = System.nanoTime();
        System.out.println("int array: " + (l2 - l) + " ns");
        l = System.nanoTime();
        n = 0;
        for (int i = 0; i < integerArray.length; ++i) {
            n += integerArray[i].intValue();
        }
        l2 = System.nanoTime();
        System.out.println("Integer array: " + (l2 - l) + " ns");
    }
}
