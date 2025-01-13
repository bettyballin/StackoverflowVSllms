import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PathnameToUniqueNumber {
    public static long pathnameToUniqueNumber(String pathname) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(pathname.getBytes(StandardCharsets.UTF_8));
        long uniqueNumber = bytesToLong(hashBytes);
        return uniqueNumber;
    }

    private static long bytesToLong(byte[] bytes) {
        long result = 0;
        for (byte b : bytes) {
            result = (result << 8) | (b & 0xFF);
        }
        return result;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String pathname = "C:\\temp\\a.out";
        long uniqueNumber = pathnameToUniqueNumber(pathname);
        System.out.println("Unique Number: " + uniqueNumber);
    }
}