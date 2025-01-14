import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordExporter {
    public static void main(String[] args) throws IOException {
        XWPFDocument document = new XWPFDocument();

        // Create table with 2 columns and 5 rows (including header)
        XWPFTable table = document.createTable(5, 2);

        // Set the table headings
        table.getRow(0).getCell(0).setText("ID");
        table.getRow(0).getCell(1).setText("Name");

        for (int i = 1; i < 5; i++) {
            XWPFTableRow row = table.getRow(i);
            row.getCell(0).setText(String.valueOf(i - 1));
            row.getCell(1).setText("User " + (i - 1));
        }

        try (FileOutputStream out = new FileOutputStream("document.docx")) {
            document.write(out);
        }
        document.close();
    }
}