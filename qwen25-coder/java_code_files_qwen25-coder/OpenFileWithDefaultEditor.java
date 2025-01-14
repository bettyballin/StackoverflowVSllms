import java.lang.String;
import java.io.File;
import java.io.IOException;

public class OpenFileWithDefaultEditor {
    public static void openFile(File file) {
        if (file.exists()) {
            try {
                // Check the operating system and use xdg-open for Unix-like systems
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    ProcessBuilder pb = new ProcessBuilder("notepad.exe", file.getAbsolutePath());
                    pb.start();
                } else {
                    // For Unix-like systems, use xdg-open
                    ProcessBuilder pb = new ProcessBuilder("xdg-open", file.getAbsolutePath());
                    pb.start();
                }
            } catch (IOException e) {
                System.err.println("Error opening file: " + e.getMessage());
            }
        } else {
            System.err.println("File does not exist.");
        }
    }

    public static void main(String[] args) {
        File csvFile = new File("/path/to/your/file.csv");
        openFile(csvFile);
    }
}