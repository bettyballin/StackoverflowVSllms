/*
 * Decompiled with CFR 0.152.
 */
public class ConcurrencyTest {
    public static void main(String[] stringArray) {
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < threadArray.length; ++i) {
            threadArray[i] = new Thread(() -> ConcurrencyTest.suspectedCode());
            threadArray[i].start();
        }
    }

    public static void suspectedCode() {
    }
}
