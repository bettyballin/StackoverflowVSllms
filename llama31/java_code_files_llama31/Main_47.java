/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main_47 {
    public static void main(String[] stringArray) throws Exception {
        String string = "Your Secret Key";
        SecretKeySpec secretKeySpec = new SecretKeySpec(string.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        String string2 = "This is a secret message";
        byte[] byArray = cipher.doFinal(string2.getBytes(StandardCharsets.UTF_8));
        System.out.println("Encrypted text: " + new String(byArray, StandardCharsets.UTF_8));
        cipher.init(2, secretKeySpec);
        byte[] byArray2 = cipher.doFinal(byArray);
        System.out.println("Decrypted text: " + new String(byArray2, StandardCharsets.UTF_8));
    }
}
