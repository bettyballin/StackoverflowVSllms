import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class RandomFileWriter {
    public static void main(String[] args) throws IOException {
        String filePath = "largefile.bin"; // Change to your file path
        long fileSize = 1_048_576_000L; // Example size: 1GB

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // Set the file length if you pre-allocate space
            raf.setLength(fileSize);

            // Create a random number generator
            Random random = new Random();

            // Example positions and byte sizes to write
            long[] writePositions = {0L, fileSize - 200L, fileSize / 2};
            int bytesToWrite = 200;

            for (long position : writePositions) {
                raf.seek(position);
                byte[] data = new byte[bytesToWrite];
                random.nextBytes(data);
                raf.write(data);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}