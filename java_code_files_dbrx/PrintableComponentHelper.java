import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JTextPane;

public class PrintableComponentHelper {
    private JTextPane textPane = new JTextPane();

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex >= 1) return Printable.NO_SUCH_PAGE;

        BufferedImage img = new BufferedImage(textPane.getWidth(), textPane.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        textPane.printAll(g2d); // or try printComponents(g2d) depending on your use case

        graphics.drawImage(img, 0, 0, null);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) {
    }
}