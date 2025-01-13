/*
 * Decompiled with CFR 0.152.
 */
public class RuntimePrinter {
    public static void main(String[] stringArray) {
        long l = System.nanoTime();
        long l2 = System.nanoTime() - l;
        double d = (double)l2 / 1.0E9;
        System.out.println("Runtime: " + d + " seconds");
    }
}
