import com.itextpdf.text.pdf.FdfReader;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_686 {
    public static void main(String[] args) throws IOException {
        // Load the PDF and FDF files
        PdfReader pdfReader = new PdfReader("path/to/pdf.pdf");
        FdfReader fdfReader = new FdfReader("path/to/fdf.fdf");

        // Merge the FDF data into the PDF
        PdfStamper stamper = new PdfStamper(pdfReader, new FileOutputStream("output.pdf"));
        stamper.setFormFlattening(true);
        stamper.setFreeTextFields(true);
        stamper.setFormFieldData(fdfReader);

        // Close the stamper and output the merged PDF
        stamper.close();

        // Close the readers to prevent resource leaks
        pdfReader.close();
        fdfReader.close();
    }
}