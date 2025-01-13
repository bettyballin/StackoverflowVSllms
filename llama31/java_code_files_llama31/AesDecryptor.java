/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesDecryptor {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = new byte[32];
        SecretKeySpec secretKeySpec = new SecretKeySpec(new byte[16], "AES");
        byte[] byArray2 = new byte[16];
        System.arraycopy(byArray, 0, byArray2, 0, byArray2.length);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, (Key)secretKeySpec, new IvParameterSpec(byArray2));
        byte[] byArray3 = cipher.doFinal(byArray, byArray2.length, byArray.length - byArray2.length);
    }
}
