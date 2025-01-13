/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Arrays;
import javax.crypto.Cipher;

public class SecureKeyExchange {
    public static void main(String[] stringArray) throws Exception {
        KeyPair keyPair = SecureKeyExchange.generateKeyPair();
        KeyPair keyPair2 = SecureKeyExchange.generateKeyPair();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, keyPair.getPublic());
        byte[] byArray = cipher.doFinal(keyPair2.getPublic().getEncoded());
        cipher.init(2, keyPair.getPrivate());
        byte[] byArray2 = cipher.doFinal(byArray);
        if (!Arrays.equals(byArray2, keyPair2.getPublic().getEncoded())) {
            throw new Exception("Key exchange failed");
        }
        byte[] byArray3 = SecureKeyExchange.generateRandomChallenge();
        byte[] byArray4 = SecureKeyExchange.encryptChallenge(byArray3, keyPair2.getPrivate());
        if (!SecureKeyExchange.verifyResponse(byArray4, byArray3, keyPair2.getPublic())) {
            throw new Exception("Authentication failed");
        }
    }

    private static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    private static byte[] generateRandomChallenge() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[32];
        secureRandom.nextBytes(byArray);
        return byArray;
    }

    private static byte[] encryptChallenge(byte[] byArray, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(byArray);
        return signature.sign();
    }

    private static boolean verifyResponse(byte[] byArray, byte[] byArray2, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(byArray2);
        return signature.verify(byArray);
    }
}
