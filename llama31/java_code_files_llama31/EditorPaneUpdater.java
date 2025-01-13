/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import javax.swing.JEditorPane;

public class EditorPaneUpdater {
    public static void main(String[] stringArray) {
        File file = new File("example.html");
        JEditorPane jEditorPane = new JEditorPane();
        try {
            jEditorPane.setPage(file.toURI().toURL());
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
