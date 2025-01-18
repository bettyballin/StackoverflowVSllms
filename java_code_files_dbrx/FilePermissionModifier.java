import java.io.File;
import java.io.IOException;

public class FilePermissionModifier {
    public FilePermissionModifier() {
        File file = new File("C:\\Program Files (x86)\\Something\\fred.txt");
        if (!file.canWrite()) {
            ProcessBuilder processBuilder = new ProcessBuilder(System.getProperty("user.dir") + "\\attrib", "-s", ".\"" + file.getAbsolutePath() + "\"");
            // Change the path to the location of attrib.exe according to your system.
            try {
                Process p = processBuilder.start();
            } catch (IOException e) {
                // Error handling code goes here
                System.out.println("Error: " + e);
            }
        }
    }

    public static void main(String[] args) {
        new FilePermissionModifier();
    }
}