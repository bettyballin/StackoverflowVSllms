/*
 * Decompiled with CFR 0.152.
 */
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESExample_2 {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = "your_secret_key_16_bytes_long".getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        String string = "Hello, World!";
        byte[] byArray2 = cipher.doFinal(string.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(byArray2));
    }
}
