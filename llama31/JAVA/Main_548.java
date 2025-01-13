import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.IOException;

public class Main_548 {
    public static void main(String[] args) {
        String filePath = "example.xlsx"; // Path to your Excel file
        try {
            // Load the Excel file
            Workbook workbook = WorkbookFactory.create(new File(filePath));

            // Since workbook.getXml() is not valid, let's just print the workbook's sheet names as an example
            System.out.println("Loaded workbook with sheets:");
            workbook.sheetIterator().forEachRemaining(sheet -> System.out.println(sheet.getSheetName()));
        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e) {
            System.out.println("Error loading Excel file: " + e.getMessage());
        }
    }
}