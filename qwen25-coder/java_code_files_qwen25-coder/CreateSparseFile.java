import java.lang.String;
import java.io.RandomAccessFile;
import java.io.IOException;

public class CreateSparseFile {
    public static void main(String[] args) {
        String filePath = "sparseFile.dat";
        long fileSize = 1024 * 1024 * 1024; // 1 GB

        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            file.setLength(fileSize);
        } catch (IOException e) {
            System.err.println("Error creating sparse file: " + e.getMessage());
        }
    }
}