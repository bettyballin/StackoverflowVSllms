/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main_360 {
    public static void main(String[] stringArray) throws Exception {
        String string = "creditCardNumber";
        String string2 = "your_secret_key_here";
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, new SecretKeySpec(string2.getBytes(), "AES"));
        byte[] byArray = cipher.doFinal(string.getBytes());
        System.out.println("Encrypted data: " + Arrays.toString(byArray));
    }
}
