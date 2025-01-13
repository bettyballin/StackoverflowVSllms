/*
 * Decompiled with CFR 0.152.
 */
public class TesseractNative {
    public native String doOCR(byte[] var1);

    public static void main(String[] stringArray) {
    }

    static {
        System.loadLibrary("tess_jni");
    }
}
