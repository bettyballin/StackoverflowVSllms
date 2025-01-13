/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JTextPane;

public class PrintableTextPane
implements Printable {
    private JTextPane textPane;

    public PrintableTextPane(JTextPane jTextPane) {
        this.textPane = jTextPane;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int n) throws PrinterException {
        if (n >= 1) {
            return 1;
        }
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        BufferedImage bufferedImage = new BufferedImage((int)pageFormat.getImageableWidth(), (int)pageFormat.getImageableHeight(), 1);
        Graphics2D graphics2D2 = bufferedImage.createGraphics();
        this.textPane.print(graphics2D2);
        graphics2D.drawImage((Image)bufferedImage, 0, 0, null);
        return 0;
    }

    public static void main(String[] stringArray) {
    }
}
