/*
 * Decompiled with CFR 0.152.
 */
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        ++this.count;
    }

    public synchronized int getCount() {
        return this.count;
    }

    public static void main(String[] stringArray) {
    }
}
