import java.lang.String;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGraphics2D;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class SvgImageExample {
    public static void main(String[] args) throws Exception {
        // Load the SVG image
        InputStream svgStream = SvgImageExample.class.getResourceAsStream("logo.svg");

        // Create a new PDF document
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.open();

        // Create a PdfGraphics2D object
        PdfContentByte cb = writer.getDirectContent();
        PdfGraphics2D graphics = new PdfGraphics2D(cb, 100, 100);

        // Draw the SVG image onto the PdfGraphics2D object
        Graphics2D g2d = graphics.createGraphics();
        SVGIcon svgIcon = new SVGIcon(svgStream);
        svgIcon.paintIcon(null, g2d, 0, 0);

        // Dispose of the Graphics2D object
        g2d.dispose();

        // Close the PDF document
        document.close();
    }
}