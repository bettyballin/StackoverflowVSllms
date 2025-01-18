import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.Printable;

public class TicketPrintPage implements Printable {
    private File ticket;

    public TicketPrintPage(File f) {
        ticket = f;
    }
    // ... rest of the class unchanged, except for print() method below

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Courier", Font.PLAIN, 10));
        int x = (int) pf.getImageableX();
        int y = (int) pf.getImageableY() + g.getFontMetrics().getAscent(); // start drawing from the baseline
        try (BufferedReader br = new BufferedReader(new FileReader(ticket))) {
            String s;
            while ((s = br.readLine()) != null) {
                if (!g2.hitClip(x, y - 10, g2.getFontMetrics().stringWidth(s), 20)) { // Check if the next line will fit on current page or not?
                    return PAGE_EXISTS;
                }
                g2.drawString(s, x, y);
                y += 15; // adjust with your interline value as required
            }
        } catch (IOException e) {
            throw new PrinterException("Error while reading ticket file: " + e.getMessage());
        }
        return NO_SUCH_PAGE; // no next page
    }

    public static void main(String[] args) {
    }
}