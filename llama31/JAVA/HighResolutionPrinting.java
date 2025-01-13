import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.standard.PrintQuality;

public class HighResolutionPrinting {
    public static void main(String[] args) throws PrinterException {
        // Create a printer job
        PrinterJob job = PrinterJob.getPrinterJob();

        // Set the print quality to high (300 dpi)
        job.getPrintRequestAttributeSet().add(new PrintQuality(300));

        // Create a page format with the desired resolution
        PageFormat pageFormat = new PageFormat();
        pageFormat.setPaper(new Paper());
        pageFormat.getPaper().setSize(595, 842); // A4 size in points (72 dpi)
        pageFormat.getPaper().setImageableArea(0, 0, 595, 842); // no margins

        // Create a buffered image with the desired resolution
        BufferedImage image = new BufferedImage(2480, 3508, BufferedImage.TYPE_INT_RGB); // A4 size in pixels (300 dpi)

        // Draw your graphics on the buffered image
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        // Draw your barcode or other graphics here
        g2d.dispose();

        // Set the page format and print the image
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics g, PageFormat pf, int pageIndex) {
                if (pageIndex == 0) {
                    g.drawImage(image, 0, 0, null);
                    return Printable.PAGE_EXISTS;
                }
                return Printable.NO_SUCH_PAGE;
            }
        }, pageFormat);

        // Print the job
        job.print();
    }
}