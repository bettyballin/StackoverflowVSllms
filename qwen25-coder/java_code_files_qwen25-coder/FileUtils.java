import java.io.File;
import java.io.IOException;

public class FileUtils {
    String filePath = "C:\\Program Files (x86)\\Something\\fred.txt";
    File file = new File(filePath);

    public FileUtils() {
        // Attempt to create the file if it does not exist.
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }

        // Use command line to ensure the file is not hidden
        String command = "attrib -h \"" + filePath.replace("\\", "\\\\") + "\"";
        try {
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Command failed with exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("file.canWrite() = " + file.canWrite());
    }

    public static void main(String[] args) {
        new FileUtils();
    }
}