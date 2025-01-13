/*
 * Decompiled with CFR 0.152.
 */
public class SecureClassLoader
extends ClassLoader {
    @Override
    protected Class<?> findClass(String string) throws ClassNotFoundException {
        byte[] byArray = this.loadEncryptedClass(string);
        byte[] byArray2 = this.decrypt(byArray);
        return this.defineClass(string, byArray2, 0, byArray2.length);
    }

    private byte[] loadEncryptedClass(String string) {
        return new byte[0];
    }

    private byte[] decrypt(byte[] byArray) {
        return byArray;
    }

    public static void main(String[] stringArray) {
    }
}
