/*
 * Decompiled with CFR 0.152.
 */
public class PKCS7PaddingUtil {
    public static byte[] pkcs7Pad(byte[] byArray, int n) {
        int n2 = n - byArray.length % n;
        byte[] byArray2 = new byte[byArray.length + n2];
        System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
        for (int i = byArray.length; i < byArray2.length; ++i) {
            byArray2[i] = (byte)n2;
        }
        return byArray2;
    }

    public static byte[] pkcs7Unpad(byte[] byArray, int n) {
        byte by = byArray[byArray.length - 1];
        if (by > n || by < 1) {
            throw new RuntimeException("Invalid padding");
        }
        for (int i = byArray.length - 1; i >= byArray.length - by; --i) {
            if (byArray[i] == (byte)by) continue;
            throw new RuntimeException("Invalid padding");
        }
        byte[] byArray2 = new byte[byArray.length - by];
        System.arraycopy(byArray, 0, byArray2, 0, byArray2.length);
        return byArray2;
    }

    public static void main(String[] stringArray) {
    }
}
