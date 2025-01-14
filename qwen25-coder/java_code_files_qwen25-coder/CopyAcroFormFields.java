import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyAcroFormFields {
    public static void main(String[] args) throws Exception {
        String src = "source.pdf";
        String dest = "destination.pdf";
        String output = "output.pdf";

        try (PdfDocument sourceDoc = new PdfDocument(new PdfReader(src));
             PdfDocument destDoc = new PdfDocument(new PdfReader(dest), new PdfWriter(output))) {

            // Get the AcroForm from the source document
            PdfAcroForm sourceForm = PdfAcroForm.getAcroForm(sourceDoc, false);
            if (sourceForm == null) {
                throw new IllegalStateException("Source PDF does not contain any form fields.");
            }

            // Copy the AcroForm to the destination document
            sourceForm.copyTo(destDoc);
        }
    }
}