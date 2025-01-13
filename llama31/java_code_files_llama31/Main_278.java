/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main_278 {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = "Hello, World!".getBytes();
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec("your_secret_key".getBytes(), "AES");
        cipher.init(1, secretKeySpec);
        byte[] byArray2 = cipher.doFinal(byArray);
        cipher.init(2, secretKeySpec);
        byte[] byArray3 = cipher.doFinal(byArray2);
        System.out.println("Encrypted Data: " + new String(byArray2));
        System.out.println("Decrypted Data: " + new String(byArray3));
    }
}
