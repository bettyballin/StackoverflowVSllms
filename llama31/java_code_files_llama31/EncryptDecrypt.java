/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {
    public static void main(String[] stringArray) throws Exception {
        String string = "mysecretpassword";
        String string2 = "myusername";
        SecretKeySpec secretKeySpec = new SecretKeySpec("mysecretkey".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        byte[] byArray = cipher.doFinal(string2.getBytes());
        byte[] byArray2 = cipher.doFinal(string.getBytes());
        cipher.init(2, secretKeySpec);
        byte[] byArray3 = cipher.doFinal(byArray);
        byte[] byArray4 = cipher.doFinal(byArray2);
        System.out.println("Encrypted user name: " + new String(byArray));
        System.out.println("Encrypted password: " + new String(byArray2));
        System.out.println("Decrypted user name: " + new String(byArray3));
        System.out.println("Decrypted password: " + new String(byArray4));
    }
}
