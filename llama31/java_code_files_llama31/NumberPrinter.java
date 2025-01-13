/*
 * Decompiled with CFR 0.152.
 */
public class NumberPrinter {
    public void run() {
        System.out.println("Thread started");
        for (int i = 1; i < 1000000000; ++i) {
            if (i % 500000 != 0) continue;
            System.out.println(i);
        }
        System.out.println("Thread finished");
    }

    public static void main(String[] stringArray) {
        NumberPrinter numberPrinter = new NumberPrinter();
        numberPrinter.run();
    }
}
