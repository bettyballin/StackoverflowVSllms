// Example of using Apache POI to read an Excel file
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static void main(String[] args) throws Exception {
        Workbook workbook = new XSSFWorkbook("path/to/file.xlsx");
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }
    }
}