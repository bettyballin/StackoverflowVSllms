import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileIdentityCalculator {
    private static final int SAMPLE_SIZE = 4096; // 4KB
    private static final int NUM_SAMPLES = 3;

    public static String calculateFileIdentity(File file) throws IOException {
        // Get file size
        long fileSize = file.length();

        // Create a byte array to store the sample
        byte[] sample = new byte[SAMPLE_SIZE * NUM_SAMPLES];

        // Open the file and read the samples
        try (FileInputStream fis = new FileInputStream(file)) {
            // Read the beginning of the file
            fis.read(sample, 0, SAMPLE_SIZE);

            // Read the middle of the file
            fis.skip(fileSize / 2 - SAMPLE_SIZE / 2);
            fis.read(sample, SAMPLE_SIZE, SAMPLE_SIZE);

            // Read the end of the file
            fis.skip(fileSize - SAMPLE_SIZE);
            fis.read(sample, 2 * SAMPLE_SIZE, SAMPLE_SIZE);
        }

        // Calculate the hash of the sample
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256"); // Replaced "xxHash" with "SHA-256"
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] sampleHash = md.digest(sample);

        // Combine file size and sample hash
        String fileSizeStr = Long.toString(fileSize);
        byte[] combined = (fileSizeStr + bytesToHex(sampleHash)).getBytes();

        // Calculate the final hash
        md.update(combined);
        byte[] finalHash = md.digest();

        return bytesToHex(finalHash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file");
            System.out.println(calculateFileIdentity(file));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}