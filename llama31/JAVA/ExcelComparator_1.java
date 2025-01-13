import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelComparator_1_1 {

    public boolean compareExcelFiles(String filePath1, String filePath2) throws IOException {
        Workbook workbook1 = new XSSFWorkbook(new FileInputStream(filePath1));
        Workbook workbook2 = new XSSFWorkbook(new FileInputStream(filePath2));

        return workbook1.equals(workbook2);
    }

    public static void main(String[] args) throws IOException {
        ExcelComparator_1 comparator = new ExcelComparator_1();
        String filePath1 = "path_to_your_first_excel_file.xlsx";
        String filePath2 = "path_to_your_second_excel_file.xlsx";
        boolean areEqual = comparator.compareExcelFiles(filePath1, filePath2);
        System.out.println("Are the Excel files equal? " + areEqual);
    }
}