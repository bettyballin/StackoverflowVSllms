import java.io.File;
import java.lang.String;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class PDFViewer {
    public static void main(String[] args) throws Exception {
        String pdfPath = "path/to/your/document.pdf";
        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            // Handle form data here
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();
            
            // Assuming you have a mapping of fields to values
            if (acroForm != null) {
                acroForm.getField("fieldName").setValue("fieldValue");
            }

            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300); // Render the first page with a resolution of 300 DPI
            ImageIcon imageIcon = new ImageIcon(bim);

            JLabel label = new JLabel();
            label.setIcon(imageIcon);
            
            JFrame frame = new JFrame("PDF Viewer");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.getContentPane().add(label);
            frame.pack();
            frame.setVisible(true);
        }
    }
}