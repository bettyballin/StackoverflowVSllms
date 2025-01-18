import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Main_250 {
    public static void main(String[] args) {
        ActiveXComponent xl = new ActiveXComponent("Excel.Application");   // Create new Excel Application object
        try {
            Dispatch workBooks = xl.getProperty("Workbooks").toDispatch();  // Get the workbooks collection
            System.out.println(workBooks);

            Dispatch.call(workBooks, "Open", "/path/to/excel_file.xlsx");         // Open your excel file

            xl.setProperty("Visible", new Variant(true));  // Make Excel visible (optional)

            // Get a worksheet and read value from a specific cell
            Dispatch workSheet = xl.getProperty("ActiveWorkbook").toDispatch().getProperty("ActiveSheet").toDispatch();  // Get the active sheet
            Variant cellValue = Dispatch.call(workSheet, "Range", "A1").getProperty("Value");  // Get content of A1 cell in worksheet
            System.out.println("The value I want is: " + cellValue);  // Print out the value
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Dispatch.call(xl, "Quit");  // Close Excel application process after done working with it to free resources
        }
    }
}