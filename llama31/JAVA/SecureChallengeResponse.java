import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class SecureChallengeResponse {
    public static void main(String[] args) throws Exception {
        // Generate server's key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey serverPrivateKey = kp.getPrivate();
        PublicKey serverPublicKey = kp.getPublic();

        // Client requests challenge
        SecureRandom random = new SecureRandom();
        byte[] challenge = new byte[32];
        random.nextBytes(challenge);

        // Client generates session key and encrypts it with server's public key
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey sessionKey = kg.generateKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, serverPublicKey);
        byte[] encryptedSessionKey = cipher.doFinal(sessionKey.getEncoded());

        // Server decrypts session key
        cipher.init(Cipher.DECRYPT_MODE, serverPrivateKey);
        byte[] decryptedSessionKey = cipher.doFinal(encryptedSessionKey);
        SecretKeySpec sessionKeySpec = new SecretKeySpec(decryptedSessionKey, "AES");

        // Client hashes password with challenge
        String password = "mysecretpassword";
        byte[] hashedPassword = hashPassword(password, challenge);

        // Client encrypts hashed password with session key
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, sessionKeySpec);
        byte[] encryptedHashedPassword = cipher.doFinal(hashedPassword);

        // Server verifies hashed password
        byte[] storedPassword = hashPassword("mysecretpassword", challenge);
        cipher.init(Cipher.DECRYPT_MODE, sessionKeySpec);
        byte[] decryptedHashedPassword = cipher.doFinal(encryptedHashedPassword);
        if (Arrays.equals(storedPassword, decryptedHashedPassword)) {
            System.out.println("Access granted");
        }
    }

    private static byte[] hashPassword(String password, byte[] challenge) throws Exception {
        // Use a secure password hashing algorithm like PBKDF2 or Argon2
        // For simplicity, this example uses a simple SHA-256 hash
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        md.update(challenge);
        return md.digest();
    }
}