/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DataEncryptor {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = "your_secret_key_here".getBytes();
        byte[] byArray2 = "your_iv_here".getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(byArray2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, (Key)secretKeySpec, ivParameterSpec);
        String string = "your_sensitive_data_here";
        byte[] byArray3 = cipher.doFinal(string.getBytes());
        System.out.println("Encrypted data: " + new String(byArray3));
    }
}
