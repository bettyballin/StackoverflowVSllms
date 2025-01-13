import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOpener_2_2 {
    private static final Logger LOGGER = Logger.getLogger(FileOpener_2.class.getName());

    private static void openApplicationSelectionWindow(File file) {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            try {
                ProcessBuilder pb = new ProcessBuilder("rundll32.exe", "url.dll,FileProtocolHandler", file.getAbsolutePath(), "/select");
                pb.start();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error opening application selection window on Windows", e);
            }
        } else if (osName.startsWith("Linux")) {
            try {
                ProcessBuilder pb = new ProcessBuilder("mimeopen", "-d", file.getAbsolutePath());
                pb.start();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error opening application selection window on Linux", e);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        File file = new File("example.txt");
        openApplicationSelectionWindow(file);
    }
}