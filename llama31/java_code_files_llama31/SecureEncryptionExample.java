/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SecureEncryptionExample {
    public static void main(String[] stringArray) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[32];
        secureRandom.nextBytes(byArray);
        byte[] byArray2 = new byte[16];
        secureRandom.nextBytes(byArray2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray2);
        byte[] byArray3 = "Hello, World!".getBytes();
        cipher.init(1, (Key)secretKeySpec, ivParameterSpec);
        byte[] byArray4 = cipher.doFinal(byArray3);
        cipher.init(2, (Key)secretKeySpec, ivParameterSpec);
        byte[] byArray5 = cipher.doFinal(byArray4);
        System.out.println(new String(byArray5));
    }
}
