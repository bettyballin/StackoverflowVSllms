/*
 * Decompiled with CFR 0.152.
 */
public class Example_14 {
    private final Object lock = new Object();
    private int counter = 0;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void increment() {
        Object object = this.lock;
        synchronized (object) {
            ++this.counter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getCounter() {
        Object object = this.lock;
        synchronized (object) {
            return this.counter;
        }
    }

    public static void main(String[] stringArray) {
    }
}
