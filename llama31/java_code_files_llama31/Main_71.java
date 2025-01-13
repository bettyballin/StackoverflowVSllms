/*
 * Decompiled with CFR 0.152.
 */
public class Main_71 {
    public static void main(String[] stringArray) {
        long l = System.nanoTime();
        Main_71.myFunction();
        long l2 = System.nanoTime();
        long l3 = l2 - l;
        double d = (double)l3 / 1000000.0;
        System.out.println("Time taken by myFunction(): " + d + " milliseconds");
    }

    public static void myFunction() {
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
