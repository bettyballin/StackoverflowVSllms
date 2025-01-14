import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ComExample {
    public static void main(String[] args) {
        try {
            // Create an instance of the COM object
            ActiveXComponent excel = new ActiveXComponent("Excel.Application");

            // Make Excel visible
            excel.setProperty("Visible", new Variant(true));

            // Get workbooks collection
            Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();

            // Add a new workbook
            Dispatch workbook = Dispatch.call(workbooks, "Add").toDispatch();

            // Get first worksheet
            Variant sheetNo = new Variant(1);
            Dispatch sheets = Dispatch.get(workbook, "Sheets").toDispatch();
            Dispatch sheet = Dispatch.call(sheets, "Item", sheetNo).toDispatch();

            // Set cell values in the worksheet
            Dispatch cell = Dispatch.invoke(sheet, "Cells", Dispatch.Get, new Object[]{new Variant(1), new Variant(1)}, new int[1]).toDispatch();
            Dispatch.put(cell, "Value", "Hello World!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}