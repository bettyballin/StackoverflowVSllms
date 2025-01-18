import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.geom.Matrix;

public class PdfExample {
    public static void main(String[] args) {
        try {
            PdfWriter writer = new PdfWriter("output.pdf");
            PdfDocument pdfDoc = new PdfDocument(writer);
            PageSize ps = PageSize.A4; // set page size you are looking to print at, such as Letter/LetterXL
            int pagesPerSheet;

            // create and add document with high-res (300dpi) images
            PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage(ps)); // single-page test
            double scaleFactor = 300. / 72.; // scaling factor, for DPI as per requirement
            Matrix scaleMatrix = new Matrix((float)scaleFactor, 0f, 0f, (float)scaleFactor, 0f, 0f);
            canvas.concatMatrix(scaleMatrix);
            // now draw your images at original size; they will be scaled up and rendered with high-res by subsequent printing utility
            try {
                // code to add/draw content - text/image etc. using Java2D or pdfDoc (iText) calls depending upon requirements...
            } catch(Exception e) { /* your error handling */ }
            pdfDoc.close(); // finished creating PDF, close and output it for further printing utility like Jasper Reports.
        } catch(Exception e) {
            /* your error handling */
            e.printStackTrace();
        }
    }
}