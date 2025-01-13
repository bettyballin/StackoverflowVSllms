import java.lang.String;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenPdfAtPage_2 {
    public static void main(String[] args) throws IOException {
        String filePath = "/path/to/your/file.pdf";
        int pageNumber = 5; // page number to open

        // using named destination (e.g. "page=5")
        String url = "file://" + filePath + "#page=" + pageNumber;

        // using page parameter (e.g. "page=5")
        // String url = "file://" + filePath + "?page=" + pageNumber;

        Desktop.getDesktop().browse(java.net.URI.create(url));
    }
}