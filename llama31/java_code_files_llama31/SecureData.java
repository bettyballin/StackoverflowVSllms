/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecureData {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static byte[] encrypt(byte[] byArray, byte[] byArray2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray2, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(byArray);
    }

    public static byte[] decrypt(byte[] byArray, byte[] byArray2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray2, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
