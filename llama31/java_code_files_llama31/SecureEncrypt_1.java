/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecureEncrypt_1 {
    public static byte[] encrypt(byte[] byArray, byte[] byArray2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray2, "AES");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(byArray);
    }

    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = "Hello, World!".getBytes();
        byte[] byArray2 = "mysecretkey1234".getBytes();
        byte[] byArray3 = SecureEncrypt_1.encrypt(byArray, byArray2);
        System.out.println(Arrays.toString(byArray3));
    }
}
