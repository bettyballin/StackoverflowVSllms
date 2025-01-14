import java.lang.String;
import java.lang.Set;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfNumber;
import com.itextpdf.kernel.pdf.PdfArray;
import com.itextpdf.kernel.pdf.PdfObject;
import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfPageLabels;
import com.itextpdf.kernel.pdf.action.PdfAction;

public class SetPdfMagnification {
    public static void main(String[] args) throws Exception {
        String src = "input.pdf";
        String dest = "output.pdf";

        // Initialize PDF reader and writer
        PdfReader reader = new PdfReader(src);
        PdfWriter writer = new PdfWriter(dest);

        // Create PDF Document instance with the specified document structure modes
        PdfDocument pdfDoc = new PdfDocument(reader, writer);

        /*
         * The view parameters are set after the document is closed,
         * which means you need to create a Document object as well.
         */
        Document doc = new Document(pdfDoc);
        doc.close();

        // Set initial page and zoom factor
        pdfDoc.getCatalog().setPageMode(PdfName.UseNone); // Ensures no bookmarks or thumbnails panel appears
        pdfDoc.setDefaultPageSize(pdfDoc.getFirstPage().getPageSize());

        // Set page labels
        PdfPageLabels pageLabels = new PdfPageLabels();
        pageLabels.addPageLabel(1, PdfPageLabels.EMPTY, "", 1);
        pdfDoc.getCatalog().setPageLabels(pageLabels);

        // Set the OpenAction to set initial page and zoom
        PdfArray openAction = new PdfArray();
        openAction.add(new PdfNumber(1)); // Page number
        openAction.add(PdfName.FitH);
        openAction.add(new PdfNumber(500)); // Vertical position

        pdfDoc.getCatalog().put(PdfName.OpenAction, openAction);

        // Set the zoom factor
        PdfPage page = pdfDoc.getFirstPage();
        PdfDictionary pageDict = page.getPdfObject();
        pageDict.put(new PdfName("ViewArgs"), new PdfArray(new PdfObject[]{
                PdfName.FitH,
                new PdfNumber(72)
        }));

        pdfDoc.close();
    }
}