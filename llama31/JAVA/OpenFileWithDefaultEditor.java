import java.lang.String;
import java.awt.Desktop;
import java.io.File;

public class OpenFileWithDefaultEditor {
    public static void main(String[] args) {
        File file = new File("path/to/your/file.csv");
        try {
            Desktop.getDesktop().edit(file);
        } catch (Exception e) {
            // handle exception
        }
    }
}