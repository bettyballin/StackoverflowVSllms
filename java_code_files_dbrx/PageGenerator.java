import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PageGenerator {
    public static void main(String[] args) throws Exception {
        // Create an OutputStream for the PDF file
        FileOutputStream fileOutput = new FileOutputStream("output.pdf");

        Document document = new Document(PageSize.LETTER, 0, 0, 0, 0);
        PdfWriter writer = PdfWriter.getInstance(document, fileOutput);
        document.open();

        // Create a ColumnText object
        ColumnText columnText = new ColumnText(writer.getDirectContent()); 

        // Set the width and height of the text rectangle (equal to available page space)
        columnText.setSimpleColumn(36f, 25f, PageSize.LETTER.getWidth() - 36f, 700f);

        // Add the first text element
        columnText.addElement(new Paragraph("hello world1"));

        // Define images and add them to the document
        Image img1 = Image.getInstance("image1.jpg");
        Image img2 = Image.getInstance("image2.jpg");
        document.add(img1); // directly add images to document
        document.add(img2);

        // Read image from stream and create Image object
        InputStream imageStream = new FileInputStream("image3.jpg");
        Image img3 = Image.getInstance(imageStream);

        // Process the ColumnText content
        int status = columnText.go();

        if (!columnText.hasMoreText()) { // check if there is enough space for the third image and text
            // if yes, add the third image and then the text element
            document.add(img3);
            columnText.addElement(new Paragraph("hello world2"));
        } else { // if not, end the current page manually and continue on a new page
            document.newPage();
            document.add(img3);
            // reset the rectangle to new page's dimensions
            columnText.setSimpleColumn(0f, PageSize.LETTER.getHeight() - 15f,
                                       PageSize.LETTER.getWidth(), 825f);
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT,
                                       new Phrase("hello world2"), 36f, 720f, 0);
        }

        // Repeat until there are no more elements to be added
        while (columnText.hasMoreText()) {
            document.newPage();
            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT,
                                       new Phrase("hello world2"), 36f, 720f, 0);
        }

        document.close();
    }
}