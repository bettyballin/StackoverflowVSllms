import java.lang.String;
import java.util.Set;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class SwingToPdf {
    public static void main(String[] args) throws DocumentException, IOException {
        JComponent component = new JPanel();
        component.add(new JLabel("Hello, PDF!"));
        
        // Set the size of the component
        component.setSize(component.getPreferredSize());
        component.validate();

        // Create a document with iText
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.open();

        // Create PDF template and Graphics2D object
        PdfContentByte cb = writer.getDirectContent();
        PdfTemplate tp = cb.createTemplate(component.getWidth(), component.getHeight());
        Graphics2D g2d = tp.createGraphicsShapes(component.getWidth(), component.getHeight());

        // Paint the component to the Graphics2D object
        component.paint(g2d);
        g2d.dispose();

        // Add the template to the content byte
        cb.addTemplate(tp, 36, 784 - 36); // Adjust position as needed

        document.close();
    }
}