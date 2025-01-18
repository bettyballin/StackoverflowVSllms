import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class TempDirectoryHandler {
    Path tempDirectory = null;

    public TempDirectoryHandler() {
        try {
            tempDirectory = Files.createTempDirectory("MyApp_");
        } catch (IOException e) {
            System.err.println("Unable to create temporary directory!");
            e.printStackTrace();
        } finally {
            if (tempDirectory != null) {
                try {
                    Files.deleteIfExists(tempDirectory);
                } catch (Exception ex) {
                    /*Handle it properly*/
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}