import javax.swing.JEditorPane;
import java.io.File;
import java.io.IOException;

public class EditorPaneLoader {
    public static void main(String[] args) {
        JEditorPane pane = new JEditorPane();
        File file = new File("path_to_your_file.html"); // replace with your file path
        try {
            pane.setPage(file.toURI().toURL());
        } catch (IOException e) {
            System.err.println("Error loading file: " + e.getMessage());
        }
    }
}