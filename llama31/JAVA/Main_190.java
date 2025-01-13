import java.io.File;
import java.io.IOException;

public class Main_190 {
    public static String getUniqueFileName(String directory, String extension) {
        try {
            File tempFile = File.createTempFile(null, null, new File(directory));
            String uniqueFileName = tempFile.getName();
            // delete the file, we only want the name
            tempFile.delete();
            return uniqueFileName + extension;
        } catch (IOException e) {
            // handle the exception
            return null;
        }
    }

    public static void main(String[] args) {
        // Test the method
        System.out.println(getUniqueFileName("/tmp", ".txt"));
    }
}