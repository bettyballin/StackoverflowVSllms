/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MultiKeyEncryption {
    public static void main(String[] stringArray) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        SecretKey secretKey2 = keyGenerator.generateKey();
        SecretKey secretKey3 = keyGenerator.generateKey();
        SecretKey secretKey4 = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKey);
        byte[] byArray = cipher.doFinal("Hello, World!".getBytes());
        byte[] byArray2 = MultiKeyEncryption.wrapKey(secretKey, secretKey2);
        byte[] byArray3 = MultiKeyEncryption.wrapKey(secretKey, secretKey3);
        byte[] byArray4 = MultiKeyEncryption.wrapKey(secretKey, secretKey4);
        byte[] byArray5 = MultiKeyEncryption.unwrapKey(byArray2, secretKey2);
        cipher.init(2, new SecretKeySpec(byArray5, "AES"));
        byte[] byArray6 = cipher.doFinal(byArray);
        System.out.println(new String(byArray6));
    }

    private static byte[] wrapKey(SecretKey secretKey, SecretKey secretKey2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(3, secretKey2);
        return cipher.wrap(secretKey);
    }

    private static byte[] unwrapKey(byte[] byArray, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(4, secretKey);
        return cipher.unwrap(byArray, "AES", 3).getEncoded();
    }
}
