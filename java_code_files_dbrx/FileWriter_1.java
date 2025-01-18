import java.lang.String;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter_1 {
    private void writeContent(File file, String fileContent) {
        // Note: This is Java 7+ syntax
        try (FileOutputStream to = new FileOutputStream(file)) {
            to.write(fileContent.getBytes());
            // No need for flush() if you are closing the stream immediately after writing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}