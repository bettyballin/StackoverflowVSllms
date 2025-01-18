import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Base64;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.util.Hex;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

public class UpdatePDF {

    public static void main(String[] args) {

        try (PdfDocument pdfDoc = new PdfDocument(
                new PdfReader("oldFile.pdf"),
                new PdfWriter("updatedPDF.pdf"))) {

            // Iterate over all pages
            int numPages = pdfDoc.getNumberOfPages();
            for (int i = 1; i <= numPages; i++) {
                PdfDictionary pageDict = pdfDoc.getPage(i).getPdfObject();
                PdfDictionary resources = pageDict.getAsDictionary(PdfName.Resources);
                if (resources != null) {
                    PdfDictionary fonts = resources.getAsDictionary(PdfName.Font);
                    if (fonts != null) {
                        for (PdfName fontName : fonts.keySet()) {
                            PdfDictionary fontDict = fonts.getAsDictionary(fontName);
                            if (fontDict != null && PdfName.Font.equals(fontDict.getAsName(PdfName.Type))) {
                                PdfString fontProgramStrObj = fontDict.getAsString(new PdfName("Encoded"));
                                if (fontProgramStrObj != null) {
                                    String fontProgramStr = fontProgramStrObj.getValue();
                                    ByteBuffer bb = ByteBuffer.wrap(Hex.decode(fontProgramStr));
                                    try (PdfFont pdfFont = PdfFontFactory.createFont(bb.array())) {
                                        if (!"gab".equalsIgnoreCase(pdfFont.getFontProgram().getFontNames().getFontName())) {
                                            String fontPath = "path/to/your/font.ttf"; // assign your custom font path here, must be either .TTF or .OTF
                                            byte[] fontBytes;
                                            try (InputStream is = new FileInputStream(new File(fontPath))) {
                                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                                int readByte;
                                                while ((readByte = is.read()) != -1) {
                                                    baos.write(readByte);
                                                }
                                                fontBytes = baos.toByteArray();
                                            }
                                            String encodedFont = Base64.getEncoder().encodeToString(fontBytes);
                                            fontDict.put(new PdfName("Encoded"), new PdfString(encodedFont));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}