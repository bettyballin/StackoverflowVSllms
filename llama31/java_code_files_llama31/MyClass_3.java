/*
 * Decompiled with CFR 0.152.
 */
public class MyClass_3 {
    public static void main(String[] stringArray) {
        Thread thread = new Thread((Runnable)((Object)new MyRunnable()));
        thread.start();
    }
}
