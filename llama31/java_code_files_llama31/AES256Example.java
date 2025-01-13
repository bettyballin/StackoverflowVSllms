/*
 * Decompiled with CFR 0.152.
 */
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES256Example {
    public static void main(String[] stringArray) throws Exception {
        String string = "Hello, World!";
        String string2 = "mysecretpassword";
        SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        byte[] byArray = cipher.doFinal(string.getBytes());
        cipher.init(2, secretKeySpec);
        byte[] byArray2 = cipher.doFinal(byArray);
        System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(byArray));
        System.out.println("Plaintext: " + new String(byArray2));
    }
}
