/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordAuthenticator {
    String password = "mysecretpassword";
    String salt = "randomsaltvalue";
    String nonce = this.generateNonce();
    String hashedPassword = this.hashPassword(this.password, this.salt);
    String sessionToken = this.hash(this.hashedPassword + this.nonce);

    public static void main(String[] stringArray) {
        PasswordAuthenticator passwordAuthenticator = new PasswordAuthenticator();
        System.out.println(passwordAuthenticator.sessionToken);
    }

    private String generateNonce() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        return this.bytesToHex(byArray);
    }

    private String hashPassword(String string, String string2) {
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), string2.getBytes(), 65536, 256);
            byte[] byArray = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
            return this.bytesToHex(byArray);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private String hash(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            return this.bytesToHex(byArray);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
    }

    private String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            String string = Integer.toHexString(0xFF & by);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
