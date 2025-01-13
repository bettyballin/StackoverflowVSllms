/*
 * Decompiled with CFR 0.152.
 */
public class SynchronizedExample {
    private int sharedVariable = 0;

    public synchronized void increment() {
        ++this.sharedVariable;
    }

    public static void main(String[] stringArray) {
    }
}
