import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Arrays;

import javax.crypto.Cipher;

public class SecureKeyExchange {
    public static void main(String[] args) throws Exception {
        // Generate key pairs
        KeyPair key1 = generateKeyPair();
        KeyPair key2 = generateKeyPair();

        // Encrypt key2(public) with key1(public)
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key1.getPublic());
        byte[] encryptedKey2 = cipher.doFinal(key2.getPublic().getEncoded());

        // Decrypt encrypted key2(public) with key1(private)
        cipher.init(Cipher.DECRYPT_MODE, key1.getPrivate());
        byte[] decryptedKey2 = cipher.doFinal(encryptedKey2);

        // Verify decrypted key2(public)
        if (!Arrays.equals(decryptedKey2, key2.getPublic().getEncoded())) {
            throw new Exception("Key exchange failed");
        }

        // Perform challenge-response authentication
        byte[] challenge = generateRandomChallenge();
        byte[] response = encryptChallenge(challenge, key2.getPrivate());
        if (!verifyResponse(response, challenge, key2.getPublic())) {
            throw new Exception("Authentication failed");
        }
    }

    private static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        return kpg.generateKeyPair();
    }

    private static byte[] generateRandomChallenge() {
        SecureRandom random = new SecureRandom();
        byte[] challenge = new byte[32];
        random.nextBytes(challenge);
        return challenge;
    }

    private static byte[] encryptChallenge(byte[] challenge, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(challenge);
        return signature.sign();
    }

    private static boolean verifyResponse(byte[] response, byte[] challenge, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(challenge);
        return signature.verify(response);
    }
}