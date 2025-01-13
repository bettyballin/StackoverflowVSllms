/*
 * Decompiled with CFR 0.152.
 */
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class PassphraseEncryption {
    private static final String ALGORITHM = "PBEWithHMACSHA1AndAES_128";
    private static final int ITERATIONS = 1000;

    public static byte[] encrypt(String string, String string2) throws Exception {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string2.toCharArray());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = secretKeyFactory.generateSecret(pBEKeySpec);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(1, (Key)secretKey, new PBEParameterSpec(new byte[0], 1000));
        return cipher.doFinal(string.getBytes());
    }

    public static String decrypt(byte[] byArray, String string) throws Exception {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = secretKeyFactory.generateSecret(pBEKeySpec);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(2, (Key)secretKey, new PBEParameterSpec(new byte[0], 1000));
        return new String(cipher.doFinal(byArray));
    }

    public static void main(String[] stringArray) throws Exception {
        String string = "Hello, World!";
        String string2 = "mysecretpassword";
        byte[] byArray = PassphraseEncryption.encrypt(string, string2);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(byArray));
        String string3 = PassphraseEncryption.decrypt(byArray, string2);
        System.out.println("Decrypted: " + string3);
    }
}
