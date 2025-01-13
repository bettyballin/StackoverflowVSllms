/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String getMD5Hash(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(string.getBytes(StandardCharsets.UTF_8));
            byte[] byArray = messageDigest.digest();
            string = HashUtil.byteArrToHexString(byArray);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
        return string;
    }

    private static String byteArrToHexString(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < byArray.length; ++i) {
            int n = byArray[i] & 0xFF;
            stringBuffer.append(String.format("%02x", n));
        }
        return stringBuffer.toString();
    }

    public static void main(String[] stringArray) {
        System.out.println(HashUtil.getMD5Hash("Hello, World!"));
    }
}
