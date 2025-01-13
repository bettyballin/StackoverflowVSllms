import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class RawPrintApplet {
    public void print(String data) {
        PrintService printer = PrintServiceLookup.lookupDefaultPrintService();
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(printer);
        InputStream is = new ByteArrayInputStream(data.getBytes());
        job.setPageable(new RawPrintPageable(is));
        try {
            job.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RawPrintApplet applet = new RawPrintApplet();
        applet.print("Hello, World!");
    }
}

class RawPrintPageable implements Pageable {
    private InputStream is;

    public RawPrintPageable(InputStream is) {
        this.is = is;
    }

    public int getNumberOfPages() {
        return 1;
    }

    public PageFormat getPageFormat(int pageIndex) {
        return new PageFormat();
    }

    public Printable getPrintable(int pageIndex) {
        return new RawPrintPrintable(is);
    }
}

class RawPrintPrintable implements Printable {
    private InputStream is;

    public RawPrintPrintable(InputStream is) {
        this.is = is;
    }

    public int print(Graphics g, PageFormat pf, int pageIndex) {
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
            while ((bytesRead = is.read(buffer)) != -1) {
                g.drawString(new String(buffer, 0, bytesRead), 0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PAGE_EXISTS;
    }
}