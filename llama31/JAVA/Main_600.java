import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main_600 {
    public static void main(String[] args) throws IOException {
        File file = new File("path/to/your/file");
        long fileSize = file.length();
        int chunkSize = 1024 * 1024; // 1MB chunk size
        long start = 5 * chunkSize; // start reading from 5MB into the file
        long end = start + chunkSize; // read 1MB from the start position

        FileInputStream fis = new FileInputStream(file);
        fis.skip(start); // skip to the start position
        byte[] chunk = new byte[(int) (end - start)];
        fis.read(chunk); // read the chunk
        fis.close();

        // process the chunk
    }
}