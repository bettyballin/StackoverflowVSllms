import java.io.File;
import javax.swing.JEditorPane;
import java.io.IOException;

public class TabbedPaneModelorFileNameDisplayer {
    private JEditorPane pane = new JEditorPane();
    private File file = new File("example.txt");

    {
        try {
            pane.setPage(file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}