import java.io.FileOutputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInWord {
    public static void main(String[] args) throws Exception{
        HWPFDocument document = new HWPFDocument(); //creates a blank Word 97-2003 format file
        XWPFDocument docxFile = new XWPFDocument(); // creates a word file with xml structure - newer versions of Office suite (.docx)
        FileOutputStream fos = new FileOutputStream("filename.doc");  // Save your word document to this place.
        try {
            // Add embeddable code
            XSSFWorkbook wb = new XSSFWorkbook(); // An excel file, containing the spreadsheet you want to include as an OLEObject in a Word document file (.xlsx file)
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet1 = wb.createSheet("mySampleExcel"); //name your excel sheet
            for(int r=0; r<5 /*any number*/; r++) { //filling the created spreadsheet with sample data, you can write anything here.
                Row row = sheet1.createRow(r);
                Cell cell;
                for(int c=0; c<3 /*your desired column count - replace 5*/; c++){
                    cell = row.createCell(c); // create cell at position (row-num, col-num)
                    cell.setCellValue(createHelper.createRichTextString("Content of your cells"));
                } //end of 'for each column' loop and you filled 1 more row!
            } //end of for each rows to be created at this excel sheet
            document.write(fos);
        } finally {
            if (fos != null) fos.close(); // always close your IOStream after you finish using it.
        }
    }
} // end of class