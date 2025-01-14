import java.lang.String;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class WriteBytesToFile {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String dataToWrite = "Hello, World!";
        
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            // Move the pointer to the position where you want to write
            long position = 10; // Example position: after the first 10 bytes
            file.seek(position);
            
            // Convert string to bytes and write
            byte[] dataBytes = dataToWrite.getBytes(StandardCharsets.UTF_8);
            file.write(dataBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}