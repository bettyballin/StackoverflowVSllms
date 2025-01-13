/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class OfflineAuth {
    public static void main(String[] stringArray) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        String string = "mysecretpassword";
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), byArray, 10000, 256);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] byArray2 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        String string2 = "mysecretpassword";
        PBEKeySpec pBEKeySpec2 = new PBEKeySpec(string2.toCharArray(), byArray, 10000, 256);
        byte[] byArray3 = secretKeyFactory.generateSecret(pBEKeySpec2).getEncoded();
        if (Arrays.equals(byArray2, byArray3)) {
            System.out.println("Authenticated!");
        } else {
            System.out.println("Invalid password");
        }
    }
}
