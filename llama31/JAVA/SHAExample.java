import java.lang.String;
import java.lang.Integer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "Hello, World!";
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = sha256.digest(input.getBytes());
        System.out.println(bytesToHex(hashBytes));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}