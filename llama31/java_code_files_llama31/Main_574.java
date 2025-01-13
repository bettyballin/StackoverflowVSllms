/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Main_574 {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException {
        String string = "john";
        String string2 = Main_574.hashPassword("mysecretpassword", "salt123");
        String string3 = "salt123";
        String string4 = Main_574.generateNonce();
        String string5 = Main_574.hashPassword("mysecretpassword", string3, string4);
        System.out.println("Authorization: CustomAuth username=\"" + string + "\", hashedPassword=\"" + string5 + "\", salt=\"" + string3 + "\"");
        String string6 = Main_574.hashPassword(string2, string3, string4);
        if (string6.equals(string5)) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }

    public static String hashPassword(String string, String string2) throws NoSuchAlgorithmException {
        return Main_574.hashPassword(string, string2, null);
    }

    public static String hashPassword(String string, String string2, String string3) throws NoSuchAlgorithmException {
        String string4 = string + string2 + (string3 != null ? string3 : "");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] byArray = messageDigest.digest(string4.getBytes(StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }

    public static String generateNonce() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }
}
