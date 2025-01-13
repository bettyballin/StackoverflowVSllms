import java.lang.String;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BigFileWriter_1 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("path_to_your_file");
        try (FileChannel channel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            // Write first 200 bytes
            channel.write(ByteBuffer.wrap(generateRandomBytes(200)));

            // Jump to the end and write last 200 bytes
            channel.position(200); // Assuming you know the offset
            channel.write(ByteBuffer.wrap(generateRandomBytes(200)));

            // Move to the middle and write there
            channel.position(channel.size() / 2);
            channel.write(ByteBuffer.wrap(generateRandomBytes(200)));
        }
    }

    private static byte[] generateRandomBytes(int size) {
        byte[] bytes = new byte[size];
        // Fill the bytes with random data
        // You can use SecureRandom for cryptographic-strength random numbers
        return bytes;
    }
}