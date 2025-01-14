import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.File;
import java.io.IOException;

public class PdfEnvelopeCreator {

    public static final String DEST = "enveloped_pdf.pdf";
    public static final String SRC = "original.pdf";

    protected void manipulatePdf(String src, String dest) throws IOException {
        // Initialize the PDF reader and writer
        PdfReader reader = new PdfReader(src);
        PdfWriter writer = new PdfWriter(dest);

        // Initialize the PdfDocument object with the reader and writer
        PdfDocument pdfDoc = new PdfDocument(reader, writer);

        // Load the font for watermarking
        PdfFont font = null;
        try {
            font = PdfFontFactory.createFont("Helvetica", "winansi", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the number of pages in the document
        int numberOfPages = pdfDoc.getNumberOfPages();

        for (int i = 1; i <= numberOfPages; i++) {

            PdfPage page = pdfDoc.getPage(i);

            float x = page.getPageSize().getWidth() / 2;
            float y = page.getPageSize().getHeight() / 2;

            // Create a Canvas to add content
            Canvas canvas = new Canvas(new PdfCanvas(page), pdfDoc, page.getPageSize());

            Paragraph p = new Paragraph("Confidential")
                    .setFont(font)
                    .setFontSize(60)
                    .setFontColor(ColorConstants.GRAY)
                    .setRotationAngle(Math.toRadians(45));

            canvas.showTextAligned(p, x, y, TextAlignment.CENTER, VerticalAlignment.MIDDLE);

            canvas.close();
        }

        pdfDoc.close();
        reader.close();
        writer.close();

    }

    public static void main(String[] args) throws IOException {
        try {
            File file = new File(DEST);
            file.getParentFile().mkdirs();
            new PdfEnvelopeCreator().manipulatePdf(SRC, DEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}