/*
 * Decompiled with CFR 0.152.
 */
public class Test_9 {
    public static void main(String[] stringArray) {
        try {
            Foo foo = new Foo();
            System.out.println("Created foo");
        }
        catch (Exception exception) {
            // empty catch block
        }
        System.gc();
        System.runFinalization();
    }
}
