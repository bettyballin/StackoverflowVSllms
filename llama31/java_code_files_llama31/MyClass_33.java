/*
 * Decompiled with CFR 0.152.
 */
public class MyClass_33 {
    private final Object lock = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method1() {
        Object object = this.lock;
        synchronized (object) {
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method2() {
        Object object = this.lock;
        synchronized (object) {
        }
    }

    public static void main(String[] stringArray) {
    }
}
