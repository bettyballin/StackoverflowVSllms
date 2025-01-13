/*
 * Decompiled with CFR 0.152.
 */
public class ExecutionTimeCalculator {
    public static void main(String[] stringArray) {
        long l = System.nanoTime();
        long l2 = System.nanoTime();
        long l3 = l2 - l;
        System.out.println("Execution time: " + l3 + " nanoseconds");
    }
}
