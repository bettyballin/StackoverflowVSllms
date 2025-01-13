import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class OpenPdfAtPage_3_3 {
    public static void main(String[] args) throws IOException {
        String filePath = "/path/to/your/file.pdf";
        int pageNumber = 5; // page number to open

        PDDocument document = PDDocument.load(new File(filePath));
        PDPage page = document.getPage(pageNumber - 1); // 0-based index

        // Open the PDF viewer at the specified page
        // This will depend on the viewer, e.g. Adobe Acrobat
        String url = "file://" + filePath + "#page=" + pageNumber;
        Desktop.getDesktop().browse(URI.create(url));
    }
}