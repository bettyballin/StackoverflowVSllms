/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
    public static String encrypt(String string, String string2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "AES");
        cipher.init(1, secretKeySpec);
        byte[] byArray = cipher.doFinal(string.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
