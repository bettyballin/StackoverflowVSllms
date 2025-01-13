/*
 * Decompiled with CFR 0.152.
 */
public class SillyClassName {
    private final Object moo = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method1() {
        Object object = this.moo;
        synchronized (object) {
            System.out.println("Method 1 acquired lock");
            this.method2();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void method2() {
        Object object = this.moo;
        synchronized (object) {
            System.out.println("Method 2 acquired lock");
        }
    }

    public static void main(String[] stringArray) {
        SillyClassName sillyClassName = new SillyClassName();
        sillyClassName.method1();
    }
}
