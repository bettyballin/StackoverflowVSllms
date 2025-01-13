/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ImageEncryptor {
    private static final String ALGORITHM = "AES";
    private static final String MODE = "CBC";
    private static final String PADDING = "PKCS5Padding";

    public static byte[] encrypt(byte[] byArray, SecretKeySpec secretKeySpec) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        byte[] byArray2 = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(byArray2);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray2);
        byte[] byArray3 = new byte[byArray.length];
        int n = 4096;
        for (int i = 0; i < byArray.length; i += n) {
            int n2 = Math.min(n, byArray.length - i);
            byte[] byArray4 = new byte[n2];
            System.arraycopy(byArray, i, byArray4, 0, n2);
            cipher.update(byArray4, 0, n2, byArray3, i);
        }
        byte[] byArray5 = new byte[byArray2.length + byArray3.length];
        System.arraycopy(byArray2, 0, byArray5, 0, byArray2.length);
        System.arraycopy(byArray3, 0, byArray5, byArray2.length, byArray3.length);
        return byArray5;
    }

    public static void main(String[] stringArray) {
    }
}
