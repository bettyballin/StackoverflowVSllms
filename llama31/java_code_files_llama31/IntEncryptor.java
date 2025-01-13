/*
 * Decompiled with CFR 0.152.
 */
public class IntEncryptor {
    private int secretKey;

    public IntEncryptor(int n) {
        this.secretKey = n;
    }

    public int encrypt(int n) {
        return n ^ this.secretKey;
    }

    public int decrypt(int n) {
        return n ^ this.secretKey;
    }

    public static void main(String[] stringArray) {
    }
}
