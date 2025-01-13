import java.lang.String;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main_765 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file";
        int offset = 1024; // Position where you want to write
        byte[] data = "Hello, World!".getBytes(); // Data to write

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            file.seek(offset); // Move the file pointer to the desired position
            file.write(data); // Write the data
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}