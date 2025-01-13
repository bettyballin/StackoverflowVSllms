import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class HashUtil {
    public static String getMD5Hash(String string) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(string.getBytes(StandardCharsets.UTF_8)); 
            byte[] digest = md5.digest();

            string = byteArrToHexString(digest);
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }

        return string;
    }

    private static String byteArrToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < bArr.length; i++) {
            int unsigned = bArr[i] & 0xff;
            sb.append(String.format("%02x", unsigned)); 
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getMD5Hash("Hello, World!"));
    }
}