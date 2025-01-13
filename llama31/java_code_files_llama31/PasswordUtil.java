/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
    public static String hashPassword(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes());
            return PasswordUtil.bytesToHex(byArray);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException("SHA-256 hashing algorithm not found", noSuchAlgorithmException);
        }
    }

    private static String bytesToHex(byte[] byArray) {
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

    public static void main(String[] stringArray) {
        String string = "examplePassword";
        String string2 = PasswordUtil.hashPassword(string);
        System.out.println("Hashed Password: " + string2);
    }
}
