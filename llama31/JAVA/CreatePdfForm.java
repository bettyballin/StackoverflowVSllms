// Requires iText library (e.g., itext7-7.2.4.jar)
import java.lang.String;
import java.lang.Set;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfFormField;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.geom.Rectangle; // Added import statement

public class CreatePdfForm {
    public static void main(String[] args) throws Exception {
        PdfWriter pdfWriter = new PdfWriter("path/to/output.pdf");
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        // Create a form field
        PdfFormField formField = PdfFormField.createText(pdfDocument, new Rectangle(100, 100, 200, 20), "MyField");
        formField.setFieldName("MyField");
        formField.setValue("Default value");

        // Add the form field to the PDF
        pdfDocument.addPage(formField.getPage());

        // Set the permissions
        pdfDocument.setAllowEditing(true);
        pdfDocument.setAllowSavingFilledInFormFields(true);

        // Close the PDF writer
        pdfDocument.close(); // Changed to pdfDocument.close() instead of pdfWriter.close()
    }
}