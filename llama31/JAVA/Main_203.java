import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main_203 {
    // Using SHA-256 with a sufficient work factor (e.g., iteration count)
    public static String hashString(String var1, String var2) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] input = (var1 + var2).getBytes();
            for (int i = 0; i < 10000; i++) { // adjust the work factor as needed
                md.update(input);
                input = md.digest();
            }
            return bytesToHex(input);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(hashString("Hello", "World"));
    }
}