/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AESExample_1 {
    public static void main(String[] stringArray) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        String string = "Hello, World!";
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, new byte[12]);
        cipher.init(1, (Key)secretKey, gCMParameterSpec);
        byte[] byArray = cipher.doFinal(string.getBytes());
        cipher.init(2, (Key)secretKey, gCMParameterSpec);
        byte[] byArray2 = cipher.doFinal(byArray);
        System.out.println(new String(byArray2));
    }
}
