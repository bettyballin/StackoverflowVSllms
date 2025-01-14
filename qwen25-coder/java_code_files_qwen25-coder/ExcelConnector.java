import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ExcelConnector {
    public void modifyExcel() {
        ActiveXComponent excel = new ActiveXComponent("Excel.Application");
        try {
            excel.setProperty("Visible", new Variant(true));
            Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
            Dispatch workbook = Dispatch.invoke(workbooks, "Add", Dispatch.METHOD, new Object[]{}, new int[]{}).toDispatch();
            Dispatch sheets = Dispatch.get(workbook, "Worksheets").toDispatch();
            Dispatch sheet = Dispatch.get(sheets, "Item", new Variant(1)).toDispatch();

            // Modify cell A1
            Dispatch cells = Dispatch.invoke(sheet, "Cells", Dispatch.METHOD, new Object[]{1, 1}, new int[]{}).toDispatch();
            Dispatch.put(cells, "Value", new Variant("Hello from Java using Jacob"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            excel.invoke("Quit", new Object[0]);
        }
    }

    public static void main(String[] args) {
        new ExcelConnector().modifyExcel();
    }
}