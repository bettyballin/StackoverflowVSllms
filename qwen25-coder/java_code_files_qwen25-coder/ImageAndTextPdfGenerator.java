import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageAndTextPdfGenerator {
    public static void main(String[] args) throws Exception {
        Document document = new Document(PageSize.LETTER, 0, 0, 0, 0);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.open();

        Paragraph paragraph1 = new Paragraph("hello world1");
        float availableHeight = PageSize.LETTER.getHeight() - document.bottomMargin() - document.topMargin();

        // Assuming a fixed height for the paragraph since getContentHeight() might not be available
        float paragraphHeight = 50; // Replace with actual height calculation if needed
        if (paragraphHeight > availableHeight) {
            document.newPage(); // Ensure there's enough space for the first paragraph
        }
        document.add(paragraph1);

        // Adjust available height after adding the paragraph
        availableHeight -= paragraphHeight;
        Image image = Image.getInstance("path/to/image.jpg"); // Replace with actual image path
        float imageHeight = image.getScaledHeight();

        if (availableHeight < 3 * imageHeight) { // Only 2 images can fit along with the paragraph
            document.newPage(); // Move to a new page if not enough space for all elements
            availableHeight = PageSize.LETTER.getHeight() - document.bottomMargin() - document.topMargin();
        }

        int countImagesOnCurrentPage = 0;
        for (int i = 0; i < 3; i++) {
            availableHeight -= imageHeight;
            if (availableHeight >= 0) {
                document.add(image);
                countImagesOnCurrentPage++;
            } else {
                document.newPage();
                document.add(image);
                countImagesOnCurrentPage = 1; // Reset count after new page
                availableHeight = PageSize.LETTER.getHeight() - document.bottomMargin() - document.topMargin() - imageHeight;
            }
        }

        Paragraph paragraph2 = new Paragraph("hello world2");
        document.add(paragraph2);

        document.close();
    }
}