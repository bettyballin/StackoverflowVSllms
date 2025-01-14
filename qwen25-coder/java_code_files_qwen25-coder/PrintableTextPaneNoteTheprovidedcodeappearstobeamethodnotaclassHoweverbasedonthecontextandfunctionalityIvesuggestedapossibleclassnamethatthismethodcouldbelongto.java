import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.RepaintManager;
import javax.swing.JTextPane;

public class PrintableTextPane implements Printable {
    private JTextPane textPane; 

    public PrintableTextPane(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex >= 1) return Printable.NO_SUCH_PAGE;

        RepaintManager mgr = RepaintManager.currentManager(textPane);
        mgr.setDoubleBufferingEnabled(false);

        final Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Set font rendering hints for better appearance during print
        graphics2D.setFont(new Font("Arial", Font.PLAIN, 14));
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

        textPane.printAll(graphics2D);
        mgr.setDoubleBufferingEnabled(true);

        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) {
        // Example usage:
        JTextPane textPane = new JTextPane();
        textPane.setText("Printable JTextPane content goes here.");

        PrintableTextPane printableTextPane = new PrintableTextPane(textPane);
        // Add code here to initiate printing using the PrintableTextPane instance.
    }
}