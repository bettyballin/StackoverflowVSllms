/*
 * Decompiled with CFR 0.152.
 */
public class TestAndSet {
    private volatile boolean flag = false;

    public synchronized boolean testAndSet() {
        if (!this.flag) {
            this.flag = true;
            return true;
        }
        return false;
    }

    public synchronized void reset() {
        this.flag = false;
    }

    public static void main(String[] stringArray) {
    }
}
