/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

public class AesEncryptor {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(byArray);
        Key key = null;
        byte[] byArray2 = null;
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, key, new IvParameterSpec(byArray));
        byte[] byArray3 = cipher.doFinal(byArray2);
        byte[] byArray4 = new byte[byArray.length + byArray3.length];
        System.arraycopy(byArray, 0, byArray4, 0, byArray.length);
        System.arraycopy(byArray3, 0, byArray4, byArray.length, byArray3.length);
    }
}
