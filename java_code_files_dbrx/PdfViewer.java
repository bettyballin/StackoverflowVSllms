import java.lang.String;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PdfViewer extends JPanel{
    public void showPdf(String filePath) throws Exception {
        PDDocument pdf = PDDocument.load(new File(filePath));
        int totalPages = pdf.getNumberOfPages();

        // Create a renderer to display the image in swing panel/window.
        PDFRenderer pdfRenderer = new PDFRenderer(pdf);

        for (int pageIndex = 0; pageIndex < totalPages; pageIndex++) {
            BufferedImage img = pdfRenderer.renderImageWithDPI(pageIndex, 150);

            // Create a swing panel using the above-created image.
            ImageViewer viewer = new ImageViewer();
            viewer.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));

            viewer.displayImage(img);
        }
        pdf.close();
   }

    public static void main(String[] args) {
    }
}

class ImageViewer extends JPanel {
    private BufferedImage image;
    public void displayImage(BufferedImage img) {
        this.image = img;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
}