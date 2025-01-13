/*
 * Decompiled with CFR 0.152.
 */
public class test_1 {
    static Integer foo = new Integer(1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Integer n = foo;
        synchronized (n) {
            foo = foo + 1;
            foo.notifyAll();
        }
        System.err.println("Success");
    }
}
