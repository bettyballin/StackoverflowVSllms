import java.io.FileOutputStream;
import java.lang.String;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {
  public static void main(String[] args) throws Exception {
    Document document = new Document();

    // For Chinese font
    BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); // Path to the TTF file can be added, like getClass().getResource("/path/to/yourfont").getFile();
    Font chineseFont = new Font(bfChinese, 18, Font.NORMAL);

    // For Japanese font
    BaseFont bfJapanese = BaseFont.createFont("HeiseiKakuGo-W5", "UniJIS-UCS2-H", BaseFont.NOT_EMBEDDED); // Path to the TTF file can be added, like getClass().getResource("/path/to/yourfont").getFile();
    Font japaneseFont = new Font(bfJapanese, 18, Font.NORMAL);

    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("generated.pdf"));
    document.open();
        Paragraph paragraph = new Paragraph("\u4e0d\u66b4\u72ec", chineseFont); // "\u4e0d\u66b4\u72ec" is "神" in Chinese unicode representation
        document.add(paragraph);
    paragraph = new Paragraph("\u50c5\u7269\u8a31", japaneseFont); // "\u50c5\u7269\u8a31" is "神" in Japanese unicode representation (Kanji)
        document.add(paragraph);
    document.close();
  }
}