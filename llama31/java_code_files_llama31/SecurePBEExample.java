/*
 * Decompiled with CFR 0.152.
 */
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SecurePBEExample {
    public static void main(String[] stringArray) throws Exception {
        String string = "mysecretpassword";
        String string2 = "mysalt";
        int n = 10000;
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), string2.getBytes(), n);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWithHMACSHA512AndAES_256");
        SecretKey secretKey = secretKeyFactory.generateSecret(pBEKeySpec);
        Cipher cipher = Cipher.getInstance("PBEWithHMACSHA512AndAES_256");
        cipher.init(1, secretKey);
        byte[] byArray = cipher.doFinal("mydata".getBytes());
    }
}
