import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobSheets;
import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.awt.print.*;
import java.awt.Graphics;

public class TicketPrinter {

    public void printTicketFile(File ticket, int orientation) throws IOException, PrinterException {
        if (!ticket.exists()) {
            throw new PrinterException("Ticket to print does not exist (" + ticket.getAbsolutePath() + ")!");
        }
        PrinterJob pjob = PrinterJob.getPrinterJob();
        // Get the specific printer by name
        PrintService printService = getPrintServiceByName("Your Printer Name");
        if (printService == null) {
            throw new PrinterException("Printer not found: 'Your Printer Name'");
        }
        pjob.setPrintService(printService);

        // Set job title
        pjob.setJobName(ticket.getName());

        // Page format and orientation
        PageFormat pf = pjob.defaultPage();
        pf.setOrientation(orientation);

        // Paper properties
        Paper a4Paper = new Paper();
        double paperWidth  =  8.26; // A4 width in inches
        double paperHeight = 11.69; // A4 height in inches
        double margin = 16.0; // Margin in points
        a4Paper.setSize(paperWidth * 72.0, paperHeight * 72.0); // Convert inches to points
        a4Paper.setImageableArea(
                margin,
                margin,
                a4Paper.getWidth() - 2 * margin,
                a4Paper.getHeight() - 2 * margin
        );
        pf.setPaper(a4Paper);

        // Prepare the printable page
        TicketPrintPage pages = new TicketPrintPage(ticket);
        Book book = new Book();
        book.append(pages, pf);
        pjob.setPageable(book);

        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(JobSheets.NONE);

        // Check if printer is ready before printing
        if (printService.isDocFlavorSupported(DocFlavor.INPUT_STREAM.AUTOSENSE) && printService.isAcceptingJobs()) {
            pjob.print(pras);
        } else {
            throw new PrinterException("Printer is not ready or does not support the document format.");
        }
    }

    private PrintService getPrintServiceByName(String printerName) {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService service : services) {
            if (service.getName().trim().equalsIgnoreCase(printerName)) {
                return service;
            }
        }
        return null;
    }

    class TicketPrintPage implements Printable {
        private File ticket;

        public TicketPrintPage(File ticket) {
            this.ticket = ticket;
        }

        @Override
        public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
            // Implement the print functionality here
            return NO_SUCH_PAGE;
        }
    }
}