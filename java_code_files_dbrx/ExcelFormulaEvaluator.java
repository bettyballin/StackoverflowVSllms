import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFormulaEvaluator {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("samplefile.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);    // Create an Excel file from stream, handling both pre-2007 and post-2007 files.
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        int firstVisibleTabIndex = workbook.getFirstVisibleTab();  // Get the index of the first visible tab
        Sheet sheet = workbook.getSheetAt(firstVisibleTabIndex);  // Get the first visible sheet
        for (Row row : sheet) {    // Loop over all rows in a spreadsheet to read values.
            for (Cell cell : row) {
                if (cell != null && cell.getCellType() == CellType.FORMULA) {
                    CellType resultType = evaluator.evaluateFormulaCell(cell);  // Evaluate formula, returns the type of value returned by a cell containing a formula in Excel itself
                }
            }
        }
    }
}