import java.lang.String;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ExcelAutomation {
    public static void main(String[] args) {
        ActiveXComponent xl = new ActiveXComponent("Excel.Application");
        Dispatch workbooks = xl.getProperty("Workbooks").toDispatch();
        Dispatch workbook = Dispatch.invoke(workbooks, "Open", Dispatch.Method, new Object[] { "path/to/your/file.xlsx" }, new int[1]).toDispatch();
        // ...
    }
}