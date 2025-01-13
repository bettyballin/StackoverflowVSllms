/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DES {
    public static void main(String[] stringArray) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56, new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, secretKey);
        byte[] byArray = "Hello World".getBytes();
        byte[] byArray2 = cipher.doFinal(byArray);
        cipher.init(2, secretKey);
        byte[] byArray3 = cipher.doFinal(byArray2);
        System.out.println("Plaintext: " + new String(byArray));
        System.out.println("Ciphertext: " + new String(byArray2));
        System.out.println("Decrypted: " + new String(byArray3));
    }
}
