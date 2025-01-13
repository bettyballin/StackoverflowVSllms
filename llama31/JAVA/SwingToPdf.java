import java.lang.String;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

public class SwingToPdf {
    public static void main(String[] args) throws Exception {
        JComponent component = new JPanel();
        component.add(new JLabel("Hello, World!"));
        component.setSize(300, 200); // set the component's size
        component.doLayout(); // layout the component

        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.open();

        PdfContentByte cb = writer.getDirectContent();
        PdfTemplate tp = cb.createTemplate(component.getWidth(), component.getHeight());
        Graphics2D g2d = tp.createGraphics(component.getWidth(), component.getHeight());
        g2d.translate(0, component.getHeight()); // adjust the coordinate system
        g2d.scale(1, -1); // invert the y-axis

        component.print(g2d); // use print instead of paint
        g2d.dispose();

        cb.addTemplate(tp, 50, 100); // position the template

        document.close();
    }
}