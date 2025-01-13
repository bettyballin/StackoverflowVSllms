import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main_419 {
    public static void main(String[] args) {
        // Replace with your actual data
        byte[] data = "Hello, World!".getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] checksum = md.digest(data);

            // Send the data and checksum
            System.out.println("Data: " + new String(data));
            System.out.println("Checksum: " + bytesToHex(checksum));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}