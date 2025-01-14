import java.lang.String;
import java.io.File;
import java.io.PrintWriter;

public class SafeFilename {
    public static void main(String[] args) {
        String unsafeString = "..."; // comes from external source

        // Replace or remove invalid characters for filenames
        String safeFileName = makeSafeFilename(unsafeString);

        File currentFile = new File(System.getProperty("user.home"), safeFileName);
        
        try (PrintWriter currentWriter = new PrintWriter(currentFile)) {
            // Use the writer to write data to file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String makeSafeFilename(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "default_filename";
        }

        // Define a regular expression for valid characters in filenames
        final String SAFE_FILENAME_REGEX = "[^-a-zA-Z0-9._]";
        
        // Replace all invalid characters with an underscore
        return filename.replaceAll(SAFE_FILENAME_REGEX, "_");
    }
}