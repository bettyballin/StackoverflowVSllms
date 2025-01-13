import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ChecksumVerifier {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // receive the data and checksum
        byte[] receivedData = new byte[]{}; // Replace with actual received data
        byte[] receivedChecksum = new byte[]{}; // Replace with actual received checksum

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] calculatedChecksum = md.digest(receivedData);

        if (!Arrays.equals(receivedChecksum, calculatedChecksum)) {
            System.out.println("Data corruption detected!");
        } else {
            System.out.println("Data integrity verified.");
        }
    }
}