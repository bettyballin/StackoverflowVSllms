import java.lang.String;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;

public class CreateExcel {
  public static void main(String[] args) throws Exception {
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet("new sheet");

    // row and cell creation code here (similar to Table Export example in JavaDocs)
    HSSFRow row = sheet.createRow(0);
    HSSFCell cell = row.createCell(0);
    cell.setCellValue(new HSSFRichTextString("Hello World"));

    FileOutputStream fileOut = new FileOutputStream("workbook1.xls");
    wb.write(fileOut);
    fileOut.close();
  }
}