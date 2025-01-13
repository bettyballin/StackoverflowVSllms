import java.lang.String;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenPdfAtPage {
    public static void main(String[] args) {
        int pageNum = 24;
        String manualPath = "C:\\Program Files\\Foo\\Bar\\Docs\\RefMan.pdf";

        try {
            Desktop.getDesktop().open(new File(manualPath + "#page=" + pageNum));
        } catch (IOException e) {
            System.err.println("Error opening PDF file: " + e.getMessage());
        }
    }
}