import java.io.File;
import java.io.IOException;
import javax.swing.JEditorPane;

public class FilePageLoader {
    File file = new File("path/to/your/file.html");
    JEditorPane pane = new JEditorPane();

    public FilePageLoader() {
        String filePath = new File(file.getAbsolutePath()).toURI().toString();
        try {
            pane.setPage(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FilePageLoader();
    }
}