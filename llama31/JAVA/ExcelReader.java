import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.read.biff.BiffException;

public class ExcelReader {
    public static void main(String[] args) throws BiffException, IOException {
        Workbook workbook = Workbook.getWorkbook(new File("example.xls"));
        Sheet sheet = workbook.getSheet(0);
        Cell cell = sheet.getCell(0, 0);
        System.out.println(cell.getContents());
    }
}