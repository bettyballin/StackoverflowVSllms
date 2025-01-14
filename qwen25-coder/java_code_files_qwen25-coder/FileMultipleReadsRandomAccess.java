import java.lang.String;
import java.io.RandomAccessFile;
import java.io.IOException;

public class FileMultipleReadsRandomAccess {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            // First pass through the file
            raf.seek(0);  // Go back to the beginning of the file
            String line;
            while ((line = raf.readLine()) != null) {
                System.out.println("First read: " + line);
            }

            // Second pass through the file
            raf.seek(0);  // Go back to the beginning of the file again
            while ((line = raf.readLine()) != null) {
                System.out.println("Second read: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}