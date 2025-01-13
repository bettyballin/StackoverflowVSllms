/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
    public static String encrypt(String string, String string2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] byArray = new byte[16];
        SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray);
        cipher.init(1, (Key)secretKeySpec, ivParameterSpec);
        byte[] byArray2 = cipher.doFinal(string.getBytes());
        String string3 = Base64.getEncoder().encodeToString(byArray2);
        return string3;
    }

    public static void main(String[] stringArray) {
    }
}
