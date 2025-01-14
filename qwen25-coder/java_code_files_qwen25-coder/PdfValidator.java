import java.lang.String;
import java.io.InputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PdfValidator {
    // For PDFs, Apache PDFBox can be used to check if the file is a valid PDF
    PDDocument document = null;

    public PdfValidator(InputStream nonSeekableStream) {
        try {
            document = PDDocument.load(nonSeekableStream);
            // If no exception, it's likely a valid PDF
        } catch (IOException e) {
            throw new IllegalArgumentException("File is not a valid PDF");
        }
    }

    public static void main(String[] args) {
    }
}