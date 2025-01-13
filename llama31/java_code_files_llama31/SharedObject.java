/*
 * Decompiled with CFR 0.152.
 */
public class SharedObject {
    private Object lock = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void update() {
        Object object = this.lock;
        synchronized (object) {
        }
    }

    public static void main(String[] stringArray) {
    }
}
