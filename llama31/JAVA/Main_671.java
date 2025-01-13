import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Main_671 {
    public static void main(String[] args) throws Exception {
        // Load the Excel file
        Workbook workbook = Workbook.getWorkbook(new java.io.File("path/to/excel/file.xls"));
        Sheet sheet = workbook.getSheet(0);

        // Evaluate a formula
        Cell cell = sheet.getCell(0, 0);
        String formula = cell.getContents();
        System.out.println(formula);
    }
}