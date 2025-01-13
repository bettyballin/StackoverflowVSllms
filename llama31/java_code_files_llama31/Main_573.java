/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main_573 {
    public static void main(String[] stringArray) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Main_573.generateRandomKey(32), "AES");
        byte[] byArray = "Hello, World!".getBytes();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        byte[] byArray2 = cipher.doFinal(byArray);
        System.out.println("Encrypted data: " + Base64.getEncoder().encodeToString(byArray2));
    }

    public static byte[] generateRandomKey(int n) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[n];
        secureRandom.nextBytes(byArray);
        return byArray;
    }
}
