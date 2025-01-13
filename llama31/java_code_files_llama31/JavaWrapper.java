/*
 * Decompiled with CFR 0.152.
 */
public class JavaWrapper {
    public native void callJavaMethod();

    public static void main(String[] stringArray) {
    }

    static {
        System.loadLibrary("JavaWrapper");
    }
}
