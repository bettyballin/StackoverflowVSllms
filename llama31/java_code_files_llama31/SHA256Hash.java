/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;

public class SHA256Hash {
    public static byte[] hash(byte[] byArray) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
