import java.security.MessageDigest;
import java.math.BigInteger;

public class MD5ChecksumCalculator {
    // Example Java method to calculate checksum
    public static String getMD5Checksum(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(text.getBytes());
        BigInteger no = new BigInteger(1, digest);
        String hashtext = no.toString(16);
        return hashtext;
    }

    public static void main(String[] args) {
    }
}