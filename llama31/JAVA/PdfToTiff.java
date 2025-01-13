import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfToTiff {
    public static void main(String[] args) throws IOException {
        PdfReader pdfReader = new PdfReader("input.pdf");
        PdfDocument pdfDocument = new PdfDocument(pdfReader);
        BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        com.itextpdf.kernel.pdf.canvas.PdfImageXObject img = (com.itextpdf.kernel.pdf.canvas.PdfImageXObject) pdfDocument.getPage(1).getResources().getPdfObject(com.itextpdf.kernel.pdf.PdfName.Image);
        java.awt.Image awtImage = img.getImage();
        awtImage = awtImage.getScaledInstance(image.getWidth(), image.getHeight(), java.awt.Image.SCALE_SMOOTH);
        image.getGraphics().drawImage(awtImage, 0, 0, null);
        ImageIO.write(image, "TIFF", new File("output.tiff"));
    }
}