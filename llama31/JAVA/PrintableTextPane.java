import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintableTextPane implements Printable {
    private javax.swing.JTextPane textPane;

    public PrintableTextPane(javax.swing.JTextPane textPane) {
        this.textPane = textPane;
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex >= 1) return Printable.NO_SUCH_PAGE;

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Create a new BufferedImage to render the text
        BufferedImage image = new BufferedImage((int) pageFormat.getImageableWidth(), (int) pageFormat.getImageableHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D imageGraphics = image.createGraphics();

        // Render the text on the BufferedImage
        textPane.print(imageGraphics);

        // Draw the BufferedImage on the printer graphics
        graphics2D.drawImage(image, 0, 0, null);

        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) {
    }
}