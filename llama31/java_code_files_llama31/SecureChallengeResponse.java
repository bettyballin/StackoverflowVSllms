/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SecureChallengeResponse {
    public static void main(String[] stringArray) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[32];
        secureRandom.nextBytes(byArray);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(1, publicKey);
        byte[] byArray2 = cipher.doFinal(secretKey.getEncoded());
        cipher.init(2, privateKey);
        byte[] byArray3 = cipher.doFinal(byArray2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray3, "AES");
        String string = "mysecretpassword";
        byte[] byArray4 = SecureChallengeResponse.hashPassword(string, byArray);
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        byte[] byArray5 = cipher.doFinal(byArray4);
        byte[] byArray6 = SecureChallengeResponse.hashPassword("mysecretpassword", byArray);
        cipher.init(2, secretKeySpec);
        byte[] byArray7 = cipher.doFinal(byArray5);
        if (Arrays.equals(byArray6, byArray7)) {
            System.out.println("Access granted");
        }
    }

    private static byte[] hashPassword(String string, byte[] byArray) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(string.getBytes());
        messageDigest.update(byArray);
        return messageDigest.digest();
    }
}
