/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyGenerator {
    String secretKey = "my_secret_key";
    String salt = "my_salt";
    byte[] key = MessageDigest.getInstance("MD5").digest((this.secretKey + this.salt).getBytes());

    public static void main(String[] stringArray) throws NoSuchAlgorithmException {
        new KeyGenerator();
    }
}
