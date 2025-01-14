import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.fdf.FDFDocument;

public class FDFImportExample {
    public static void main(String[] args) throws Exception {
        String pdfPath = "path/to/your/document.pdf";
        String fdfPath = "path/to/your/data.fdf";

        try (PDDocument pdfDocument = PDDocument.load(new File(pdfPath));
             FDFDocument fdfDocument = FDFDocument.load(new File(fdfPath))) {

            // Import form data to the PDF
            pdfDocument.importFDF(fdfDocument);
            
            // Save or further manipulate the pdfDocument as needed
            pdfDocument.save("path/to/save/filled_form.pdf");
        }
    }
}