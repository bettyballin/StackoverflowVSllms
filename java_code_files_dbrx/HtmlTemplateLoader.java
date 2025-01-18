import java.lang.String;
import javax.swing.JEditorPane;
import java.net.URL;
import java.io.IOException;

public class HtmlTemplateLoader {
    JEditorPane editor = new JEditorPane();
    URL url = getClass().getResource("/resources/html/custom-template.html");

    {
        try {
            editor.setPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}