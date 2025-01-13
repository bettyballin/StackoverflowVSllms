/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Main_68 {
    public static void main(String[] stringArray) throws Exception {
        PBEKeySpec pBEKeySpec = new PBEKeySpec("your_password".toCharArray(), "salt".getBytes(), 10000, 256);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyFactory.generateSecret(pBEKeySpec).getEncoded(), "AES");
        byte[] byArray = new byte[16];
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, (Key)secretKeySpec, new IvParameterSpec(byArray));
    }
}
