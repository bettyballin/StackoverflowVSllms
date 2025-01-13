import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashExample_1 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "Hello, World!";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes());
        System.out.println(bytesToHex(hash));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}