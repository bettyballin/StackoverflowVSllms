import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExampleProgram {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("example.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        if (cell.getCellType() == CellType.FORMULA) {
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            CellValue cellValue = evaluator.evaluate(cell);
            switch (cellValue.getCellType()) {
                case NUMERIC:
                    double numVal = cellValue.getNumberValue();
                    break;
                default:
                    // Handle other possible types if necessary
                    break;
            }
        }
    }
}