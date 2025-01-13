import javax.swing.JEditorPane;
import java.io.File;

public class EditorPaneUpdater {
    public static void main(String[] args) {
        File file = new File("example.html");
        JEditorPane pane = new JEditorPane();
        try {
            pane.setPage(file.toURI().toURL());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}