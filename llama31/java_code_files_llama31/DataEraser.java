/*
 * Decompiled with CFR 0.152.
 */
public class DataEraser {
    public static void secureErase(byte[] byArray) {
        if (byArray == null) {
            return;
        }
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = 0;
        }
    }

    public static void main(String[] stringArray) {
    }
}
