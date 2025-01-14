import java.lang.String;
import java.lang.Integer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UniqueFileNameGenerator {

    public static String generateUniqueFileName(String originalFileName) {
        // Generate a random UUID
        String uuid = UUID.randomUUID().toString();

        // Hash the UUID with SHA-256 to ensure a fixed length and better distribution
        String hashedUuid = hash(uuid);

        // Create a unique filename by combining the hashed UUID and file extension
        String fileExtension = getFileExtension(originalFileName);
        return hashedUuid + (fileExtension != null ? "." + fileExtension : "");
    }

    private static String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) return null;
        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(generateUniqueFileName("document.txt"));
    }
}