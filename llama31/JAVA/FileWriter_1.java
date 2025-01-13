import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_1_1 {
    public static void main(String[] args) {
        // Get the external files directory
        // NOTE: getExternalFilesDir is a method of android.content.Context, 
        // so you can't use it in a standard Java application. 
        // Here we use a hardcoded path for demonstration purposes.
        File externalFilesDir = new File("/path/to/external/files");

        // Create a new file in the external files directory
        File file = new File(externalFilesDir, "example.txt");

        try {
            // Write to the file...
            FileWriter writer = new FileWriter(file);
            writer.write("Hello, World!");
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}