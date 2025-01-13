import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main_60 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        File file = new File("path/to/file");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(getFileContents(file));

        // Store the hash value
        String hashValue = bytesToHex(hash);

        // Later, compare the new hash value with the stored one
        String newHashValue = bytesToHex(md.digest(getFileContents(file)));
        if (!newHashValue.equals(hashValue)) {
            // File has changed
            System.out.println("File has changed");
        }
    }

    private static byte[] getFileContents(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] dataBytes = new byte[(int) file.length()];
            fis.read(dataBytes);
            return dataBytes;
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}