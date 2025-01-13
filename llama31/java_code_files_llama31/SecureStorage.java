/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecureStorage {
    public static void main(String[] stringArray) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKey);
        String string = "123-45-6789";
        byte[] byArray = cipher.doFinal(string.getBytes());
        cipher.init(2, secretKey);
        byte[] byArray2 = cipher.doFinal(byArray);
        System.out.println(new String(byArray2));
    }
}
