/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main_74 {
    public static void main(String[] stringArray) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray);
        SecretKeySpec secretKeySpec = new SecretKeySpec("your_password".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, (Key)secretKeySpec, ivParameterSpec);
        byte[] byArray2 = cipher.doFinal("your_data".getBytes());
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        for (byte by : byArray3) {
            System.out.print(by + " ");
        }
    }
}
