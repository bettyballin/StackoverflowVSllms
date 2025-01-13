/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class KeyStorage {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String KEY_PASSWORD = "mysecretpassword";

    public static void main(String[] stringArray) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KeyStorage.generateRandomBytes(16), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, new SecretKeySpec(KEY_PASSWORD.getBytes(), ALGORITHM));
        byte[] byArray = cipher.doFinal(secretKeySpec.getEncoded());
        String string = Base64.getEncoder().encodeToString(byArray);
        System.out.println("Encrypted key: " + string);
    }

    private static byte[] generateRandomBytes(int n) {
        byte[] byArray = new byte[n];
        new SecureRandom().nextBytes(byArray);
        return byArray;
    }
}
