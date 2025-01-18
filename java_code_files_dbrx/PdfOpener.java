import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class PdfOpener {
    String manualPath = "C:\\Program Files\\Foo\\Bar\\Docs\\RefMan.pdf#page=24"; // Set desired page number
    Desktop desktop = Desktop.getDesktop();
    File file = new File(manualPath);
    {
        try {
            if (file.exists()) {
                desktop.open(file);
            } else {
                throw new IOException("The provided PDF does not exist.");
            }
        } catch (IOException e) {
            // Handle exception here
        }
    }
    public static void main(String[] args) {
    }
}