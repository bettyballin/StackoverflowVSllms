/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ChecksumVerifier {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException {
        byte[] byArray = new byte[]{};
        byte[] byArray2 = new byte[0];
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] byArray3 = messageDigest.digest(byArray);
        if (!Arrays.equals(byArray2, byArray3)) {
            System.out.println("Data corruption detected!");
        } else {
            System.out.println("Data integrity verified.");
        }
    }
}
