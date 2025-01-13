import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main_670 {
    public static void main(String[] args) {
        try {
            // Load the Excel file
            Workbook workbook = new HSSFWorkbook("path/to/excel/file.xls");
            Sheet sheet = workbook.getSheetAt(0);

            // Evaluate a formula
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            Object result = formulaEvaluator.evaluate(sheet.getRow(0).getCell(0));
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}