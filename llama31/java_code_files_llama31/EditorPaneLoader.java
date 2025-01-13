/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import javax.swing.JEditorPane;

public class EditorPaneLoader {
    public static void main(String[] stringArray) {
        JEditorPane jEditorPane = new JEditorPane();
        File file = new File("path_to_your_file.html");
        try {
            jEditorPane.setPage(file.toURI().toURL());
        }
        catch (IOException iOException) {
            System.err.println("Error loading file: " + iOException.getMessage());
        }
    }
}
