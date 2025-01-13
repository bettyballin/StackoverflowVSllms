import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main_431 {
    public static void main(String[] args) throws IOException {
        // Create a new Word document
        XWPFDocument wordDoc = new XWPFDocument();

        // Create a new Excel workbook
        XSSFWorkbook excelWorkbook = new XSSFWorkbook();

        // Create a new Excel worksheet
        XSSFSheet worksheet = excelWorkbook.createSheet();

        // Add some data to the worksheet
        XSSFRow row = worksheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("Hello, World!");

        // Save the Excel workbook to a temporary file
        try (FileOutputStream excelOut = new FileOutputStream("example.xlsx")) {
            excelWorkbook.write(excelOut);
        }

        // Embed the Excel worksheet in the Word document
        XWPFParagraph paragraph = wordDoc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.embedObject("application/vnd.ms-excel", "example.xlsx", worksheet.getSheetName());

        // Save the Word document
        try (FileOutputStream out = new FileOutputStream("example.docx")) {
            wordDoc.write(out);
        }

        // Clean up
        excelWorkbook.close();
        wordDoc.close();
    }
}