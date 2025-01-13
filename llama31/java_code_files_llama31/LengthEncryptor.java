/*
 * Decompiled with CFR 0.152.
 */
public class LengthEncryptor {
    public static int calculateEncryptedLength(int n) {
        return (n + 7) / 8 * 8;
    }

    public static void main(String[] stringArray) {
    }
}
