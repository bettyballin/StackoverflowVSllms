import java.lang.String;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Updater {
    private static final String APP_URL = "http://example.com/app.jar";
    private static final String DOC_PATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "MyApp";

    public void updateApplication() throws IOException {
        URL url = new URL(APP_URL);
        Path path = Path.of(DOC_PATH, "app.jar");
        
        // Ensure the directory exists
        Files.createDirectories(path.getParent());
        
        // Download and replace the application file
        Files.copy(url.openStream(), path, StandardCopyOption.REPLACE_EXISTING);
        
        System.out.println("Application updated successfully.");
    }

    public static void main(String[] args) {
        Updater updater = new Updater();
        try {
            updater.updateApplication();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}