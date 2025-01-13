/*
 * Decompiled with CFR 0.152.
 */
public class test {
    static final Object lock = new Object();
    static Integer foo = new Integer(1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Object object = lock;
        synchronized (object) {
            Integer n = foo;
            foo = foo + 1;
            lock.notifyAll();
        }
        System.err.println("Success");
    }
}
