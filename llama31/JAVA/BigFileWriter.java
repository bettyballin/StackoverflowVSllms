import java.lang.String;
import java.io.RandomAccessFile;
import java.io.IOException;

public class BigFileWriter {
    public static void main(String[] args) throws IOException {
        String filePath = "path_to_your_file";
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            // Write first 200 bytes
            file.write(generateRandomBytes(200));

            // Jump to the end and write last 200 bytes
            file.seek(200); // Assuming you know the offset
            file.write(generateRandomBytes(200));

            // Move to the middle and write there
            file.seek(file.length() / 2);
            file.write(generateRandomBytes(200));
        }
    }

    private static byte[] generateRandomBytes(int size) {
        byte[] bytes = new byte[size];
        // Fill the bytes with random data
        // You can use SecureRandom for cryptographic-strength random numbers
        return bytes;
    }
}