/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CDKeyGenerator {
    private static final int SALT_SIZE = 16;
    private static final int CDKEY_SIZE = 24;

    public static String generateCDKey(String string, String string2, String string3) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        String string4 = string + string2 + string3;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray2 = messageDigest.digest(string4.getBytes());
            byte[] byArray3 = new byte[byArray.length + byArray2.length];
            System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
            System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
            String string5 = CDKeyGenerator.bytesToHexString(byArray3);
            String string6 = string5.substring(0, 24);
            return string6;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
    }

    private static String bytesToHexString(byte[] byArray) {
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
        System.out.println(CDKeyGenerator.generateCDKey("productCode", "resellerCode", "dateString"));
    }
}
