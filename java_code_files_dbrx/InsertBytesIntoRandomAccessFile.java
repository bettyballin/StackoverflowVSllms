import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class InsertBytesIntoRandomAccessFile {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("input.txt", "rw");
            long pos = 10; // The position where you want to start writing bytes from
            byte[] bytesToInsert = "New Content".getBytes();

            // Read contents after the insertion point
            raf.seek(pos);
            byte[] remainingBytes = new byte[(int)(raf.length() - pos)];
            raf.readFully(remainingBytes);

            // Create temp file
            File tempFile = new File("temp_output.txt");
            RandomAccessFile tempRaf = new RandomAccessFile(tempFile, "rw");

            // Write bytes before the insertion point to temp file
            raf.seek(0);
            byte[] beforeBytes = new byte[(int)pos];
            raf.readFully(beforeBytes);
            tempRaf.write(beforeBytes);

            // Write bytes to insert
            tempRaf.write(bytesToInsert);

            // Write remaining bytes after the insertion point
            tempRaf.write(remainingBytes);

            // Close the files
            raf.close();
            tempRaf.close();

            // Replace original file with updated version
            Files.move(tempFile.toPath(), Paths.get("input.txt"), REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}