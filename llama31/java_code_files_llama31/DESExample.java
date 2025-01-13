/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DESExample {
    public static void main(String[] stringArray) throws Exception {
        String string = "Hello, World!";
        String string2 = "your_secret_key";
        Cipher cipher = Cipher.getInstance("DES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "DES");
        cipher.init(1, secretKeySpec);
        byte[] byArray = cipher.doFinal(string.getBytes());
        cipher.init(2, secretKeySpec);
        byte[] byArray2 = cipher.doFinal(byArray);
        System.out.println("Decrypted: " + new String(byArray2));
    }
}
