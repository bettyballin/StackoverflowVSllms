import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;

public class TicketPrintPage implements Printable {
    private final String[] textLines;
    private static final int LINES_PER_PAGE = 30; // Adjust based on font/paper size

    public TicketPrintPage(File f) throws IOException {
        List<String> lines = Files.readAllLines(f.toPath());
        textLines = lines.toArray(new String[0]);
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex >= (textLines.length + LINES_PER_PAGE - 1) / LINES_PER_PAGE) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("CourierThai", Font.PLAIN, 10));
        double y = pf.getImageableY();
        int startLineIndex = pageIndex * LINES_PER_PAGE;
        for (int i = startLineIndex; i < Math.min(startLineIndex + LINES_PER_PAGE, textLines.length); i++) {
            g2.drawString(textLines[i], (float) pf.getImageableX(), (float) y);
            y += 14; // Adjust based on font size/line height
        }
        return PAGE_EXISTS;
    }

    public static void main(String[] args) {
    }
}