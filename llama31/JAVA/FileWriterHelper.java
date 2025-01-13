import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterHelper {
    public static void main(String[] args) {
        String filename = "example.txt"; // replace with your file name
        byte[] buffer = "Hello, World!".getBytes(); // replace with your buffer
        boolean xyz = true; // replace with your condition

        try (FileOutputStream s = new FileOutputStream(filename)) {
            while (xyz) {
                s.write(buffer);
                xyz = false; // to avoid infinite loop
            }
            s.flush(); // Flushes the output stream
            s.getFD().sync(); // Force all system buffers to synchronize with the underlying device
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}