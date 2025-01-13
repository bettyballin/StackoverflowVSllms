/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AesKeyWrapper {
    public static byte[] wrap(byte[] byArray, byte[] byArray2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray2, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(byArray);
    }

    public static void main(String[] stringArray) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] byArray = "mysecretpassword".getBytes();
        byte[] byArray2 = AesKeyWrapper.wrap(secretKey.getEncoded(), byArray);
        System.out.println("Wrapped Key: " + Base64.getEncoder().encodeToString(byArray2));
    }
}
