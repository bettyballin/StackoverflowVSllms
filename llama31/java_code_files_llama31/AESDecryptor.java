/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESDecryptor {
    public static byte[] decrypt(byte[] byArray, byte[] byArray2, byte[] byArray3) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, (Key)secretKeySpec, new IvParameterSpec(byArray3));
        return cipher.doFinal(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
