/*
 * Decompiled with CFR 0.152.
 */
public class Monitor_2 {
    private int sharedVariable = 0;

    public synchronized void increment() {
        ++this.sharedVariable;
    }

    public synchronized int getSharedVariable() {
        return this.sharedVariable;
    }

    public static void main(String[] stringArray) {
    }
}
